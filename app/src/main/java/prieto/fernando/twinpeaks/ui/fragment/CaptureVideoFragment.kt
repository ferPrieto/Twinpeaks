package prieto.fernando.twinpeaks.ui.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.hardware.camera2.*
import android.hardware.camera2.params.StreamConfigurationMap
import android.media.MediaCodec
import android.media.MediaRecorder
import android.media.MediaScannerConnection
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import android.util.Range
import android.util.Size
import android.view.*
import android.webkit.MimeTypeMap
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.fragment_capture_video.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.view_bottom.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import prieto.fernando.presentation.CaptureVideoViewModel
import prieto.fernando.spacex.BuildConfig
import prieto.fernando.spacex.R
import prieto.fernando.twinpeaks.ui.MainActivity
import prieto.fernando.twinpeaks.utils.getPreviewOutputSize
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

private const val TAG = "InputTextFragment"

class CaptureVideoFragment @Inject constructor(
    viewModelFactory: ViewModelProvider.Factory
) : Fragment(R.layout.fragment_capture_video) {

    private val recorderSurface: Surface by lazy {

        // Get a persistent Surface from MediaCodec, don't forget to release when done
        val surface = MediaCodec.createPersistentInputSurface()

        // Prepare and release a dummy MediaRecorder with our new surface
        // Required to allocate an appropriately sized buffer before passing the Surface as the
        //  output target to the capture session
        createRecorder(surface).apply {
            prepare()
            release()
        }

        surface
    }

    private val recorder: MediaRecorder by lazy { createRecorder(recorderSurface) }

    private val viewModel by viewModels<CaptureVideoViewModel> { viewModelFactory }

    private val cameraManager: CameraManager by lazy {
        val context = requireContext().applicationContext
        context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
    }

    private val characteristics: CameraCharacteristics by lazy {
        cameraManager.getCameraCharacteristics(cameraInfo.cameraId)
    }

    private val outputFile: File by lazy { createFile(requireContext(), "mp4") }

    private val previewRequest: CaptureRequest by lazy {
        session.device.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW).apply {
            addTarget(camera_view.holder.surface)
        }.build()
    }

    private val recordRequest: CaptureRequest by lazy {
        session.device.createCaptureRequest(CameraDevice.TEMPLATE_RECORD).apply {
            addTarget(camera_view.holder.surface)
            addTarget(recorderSurface)
            set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, Range(cameraInfo.fps, cameraInfo.fps))
        }.build()
    }

    private val animationTask: Runnable by lazy {
        Runnable {
            overlay.foreground = Color.argb(150, 255, 255, 255).toDrawable()
            overlay.postDelayed({
                overlay.foreground = null
                overlay.postDelayed(animationTask, ANIMATION_FAST_MILLIS)
            }, ANIMATION_FAST_MILLIS)
        }
    }

    private lateinit var cameraInfo: CameraInfo

    private lateinit var session: CameraCaptureSession

    private lateinit var camera: CameraDevice

    private var recordingStartMillis: Long = 0L

    private val cameraThread = HandlerThread("CameraThread").apply { start() }

    private val cameraHandler = Handler(cameraThread.looper)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getFrontCameraCapabilities()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNavigation()
        setViewModelObservers()
        setupSurface()
        setupClickListeners()
    }

    private fun setupSurface() {
        camera_view.holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceDestroyed(holder: SurfaceHolder) = Unit
            override fun surfaceChanged(
                holder: SurfaceHolder,
                format: Int,
                width: Int,
                height: Int
            ) = Unit

            override fun surfaceCreated(holder: SurfaceHolder) {

                // Selects appropriate preview size and configures view finder
                val previewSize = getPreviewOutputSize(
                    camera_view.display, characteristics, SurfaceHolder::class.java
                )
                Log.d(TAG, "View finder size: ${camera_view.width} x ${camera_view.height}")
                Log.d(TAG, "Selected preview size: $previewSize")
                camera_view.setAspectRatio(previewSize.width, previewSize.height)

                // To ensure that size is set, initialize camera in the view's thread
                camera_view.post { initializeCamera() }
            }
        })
    }

    private fun getFrontCameraCapabilities() {
        val cameraId = cameraManager.cameraIdList[1] // 1 is front
        val characteristics = cameraManager.getCameraCharacteristics(cameraId)

        val capabilities = characteristics.get(
            CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES
        )!!
        val cameraConfig = characteristics.get(
            CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP
        )!!

        if (capabilities.contains(
                CameraCharacteristics
                    .REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE
            )
        ) {
            val targetClass = MediaRecorder::class.java
            val maxCameraSize = cameraConfig.getOutputSizes(targetClass).first()
            val fps = getFps(cameraConfig, targetClass, maxCameraSize)

            cameraInfo = CameraInfo(
                cameraId = cameraId,
                size = maxCameraSize,
                fps = fps
            )
        }
    }

    private fun getFps(
        streamConfigurationMap: StreamConfigurationMap,
        targetClass: Class<MediaRecorder>,
        cameraSize: Size
    ): Int {
        val secondsPerFrame =
            streamConfigurationMap.getOutputMinFrameDuration(targetClass, cameraSize) /
                    1_000_000_000.0
        return if (secondsPerFrame > 0) (1.0 / secondsPerFrame).toInt() else 0
    }

    override fun onResume() {
        super.onResume()
        camera_view.postDelayed({
            camera_view.systemUiVisibility = FLAGS_FULLSCREEN
        }, IMMERSIVE_FLAG_TIMEOUT)
    }

    private fun createRecorder(surface: Surface) = MediaRecorder().apply {
        setAudioSource(MediaRecorder.AudioSource.MIC)
        setVideoSource(MediaRecorder.VideoSource.SURFACE)
        setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        setOutputFile(outputFile.absolutePath)
        setVideoEncodingBitRate(RECORDER_VIDEO_BITRATE)
        if (cameraInfo.fps > 0) setVideoFrameRate(cameraInfo.fps)
        setVideoSize(cameraInfo.size.width, cameraInfo.size.height)
        setVideoEncoder(MediaRecorder.VideoEncoder.H264)
        setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        setInputSurface(surface)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initializeCamera() = lifecycleScope.launch(Dispatchers.Main) {
        camera = openCamera(cameraManager, cameraInfo.cameraId, cameraHandler)

        val targets = listOf(camera_view.holder.surface, recorderSurface)

        session = createCaptureSession(camera, targets, cameraHandler)
        session.setRepeatingRequest(previewRequest, null, cameraHandler)
    }


    private fun setupNavigation() {
        requireActivity().let { fragmentActivity ->
            (fragmentActivity as AppCompatActivity).setSupportActionBar(toolbar)
            NavigationUI.setupActionBarWithNavController(
                fragmentActivity, findNavController()
            )
        }
    }

    private fun setViewModelObservers() {
        viewModel.reversedText.observe(viewLifecycleOwner, Observer { setUpReversedStateViews(it) })
    }

    private fun setUpReversedStateViews(reversedText: String) {
        reversed_textview.text = reversedText
        changeVisibilityReversedFields(true)
        changeVisibilityOriginalFields(false)
    }

    private fun changeVisibilityReversedFields(show: Boolean) {
        reversed_textview.isVisible = show
        record_button.isVisible = show
    }

    private fun changeVisibilityOriginalFields(show: Boolean) {
        original_text.isVisible = show
        reverse_button.isVisible = show
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupClickListeners() {
        reverse_button.setOnClickListener {
            viewModel.reverseText(bottom_edit_text.text.toString())
        }

        record_button.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> lifecycleScope.launch(Dispatchers.IO) {
                    requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LOCKED
                    session.setRepeatingRequest(recordRequest, null, cameraHandler)

                    recorder.apply {
                        setOrientationHint(0)
                        prepare()
                        start()
                    }
                    recordingStartMillis = System.currentTimeMillis()
                    Log.d(TAG, "Recording started")

                    overlay.post(animationTask)
                }

                MotionEvent.ACTION_UP -> lifecycleScope.launch(Dispatchers.IO) {

                    requireActivity().requestedOrientation =
                        ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

                    val elapsedTimeMillis = System.currentTimeMillis() - recordingStartMillis
                    if (elapsedTimeMillis < MIN_REQUIRED_RECORDING_TIME_MILLIS) {
                        delay(MIN_REQUIRED_RECORDING_TIME_MILLIS - elapsedTimeMillis)
                    }

                    Log.d(TAG, "Recording stopped. Output file: $outputFile")
                    recorder.stop()

                    overlay.removeCallbacks(animationTask)

                    MediaScannerConnection.scanFile(
                        view.context, arrayOf(outputFile.absolutePath), null, null
                    )

                    // TODO: Showing the video in the same app
                    // Launch external activity via intent to play video recorded using our provider
                    startActivity(Intent().apply {
                        action = Intent.ACTION_VIEW
                        type = MimeTypeMap.getSingleton()
                            .getMimeTypeFromExtension(outputFile.extension)
                        val authority = "${BuildConfig.APPLICATION_ID}.provider"
                        data = FileProvider.getUriForFile(view.context, authority, outputFile)
                        flags = Intent.FLAG_GRANT_READ_URI_PERMISSION or
                                Intent.FLAG_ACTIVITY_CLEAR_TOP
                    })

                    // Finishes our current camera screen
                    delay(MainActivity.ANIMATION_SLOW_MILLIS)
                    findNavController().popBackStack()
                }
            }

            true
        }
    }

    @SuppressLint("MissingPermission")
    private suspend fun openCamera(
        manager: CameraManager,
        cameraId: String,
        handler: Handler? = null
    ): CameraDevice = suspendCancellableCoroutine { cont ->
        manager.openCamera(cameraId, object : CameraDevice.StateCallback() {
            override fun onOpened(device: CameraDevice) = cont.resume(device)

            override fun onDisconnected(device: CameraDevice) {
                Log.w(TAG, "Camera $cameraId has been disconnected")
                requireActivity().finish()
            }

            override fun onError(device: CameraDevice, error: Int) {
                val msg = when (error) {
                    ERROR_CAMERA_DEVICE -> "Fatal (device)"
                    ERROR_CAMERA_DISABLED -> "Device policy"
                    ERROR_CAMERA_IN_USE -> "Camera in use"
                    ERROR_CAMERA_SERVICE -> "Fatal (service)"
                    ERROR_MAX_CAMERAS_IN_USE -> "Maximum cameras in use"
                    else -> "Unknown"
                }
                val exc = RuntimeException("Camera $cameraId error: ($error) $msg")
                Log.e(TAG, exc.message, exc)
                if (cont.isActive) cont.resumeWithException(exc)
            }
        }, handler)
    }

    private suspend fun createCaptureSession(
        device: CameraDevice,
        targets: List<Surface>,
        handler: Handler? = null
    ): CameraCaptureSession = suspendCoroutine { cont ->

        // Creates a capture session using the predefined targets, and defines a session state
        // callback which resumes the coroutine once the session is configured
        device.createCaptureSession(targets, object : CameraCaptureSession.StateCallback() {

            override fun onConfigured(session: CameraCaptureSession) = cont.resume(session)

            override fun onConfigureFailed(session: CameraCaptureSession) {
                val exc = RuntimeException("Camera ${device.id} session configuration failed")
                Log.e(TAG, exc.message, exc)
                cont.resumeWithException(exc)
            }
        }, handler)
    }

    override fun onStop() {
        super.onStop()
        try {
            camera.close()
        } catch (exc: Throwable) {
            Log.e(TAG, "Error closing camera", exc)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraThread.quitSafely()
        recorder.release()
        recorderSurface.release()
    }

    companion object {
        const val FLAGS_FULLSCREEN =
            View.SYSTEM_UI_FLAG_LOW_PROFILE or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        const val ANIMATION_FAST_MILLIS = 50L
        const val ANIMATION_SLOW_MILLIS = 100L
        private const val IMMERSIVE_FLAG_TIMEOUT = 500L

        private const val RECORDER_VIDEO_BITRATE: Int = 10_000_000
        private const val MIN_REQUIRED_RECORDING_TIME_MILLIS: Long = 1000L

        /** Creates a [File] named with the current date and time */
        private fun createFile(context: Context, extension: String): File {
            val sdf = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS", Locale.US)
            return File(context.filesDir, "VID_${sdf.format(Date())}.$extension")
        }

        /** Converts a lens orientation enum into a human-readable string */
        private fun lensOrientationString(value: Int) = when (value) {
            CameraCharacteristics.LENS_FACING_BACK -> "Back"
            CameraCharacteristics.LENS_FACING_FRONT -> "Front"
            CameraCharacteristics.LENS_FACING_EXTERNAL -> "External"
            else -> "Unknown"
        }

        private data class CameraInfo(
            val cameraId: String,
            val size: Size,
            val fps: Int
        )
    }
}
