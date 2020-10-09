package fernando.prieto.data.ffmpeg

import android.util.Log
import com.arthenica.mobileffmpeg.*
import org.apache.commons.io.comparator.LastModifiedFileComparator
import java.io.File
import java.util.*
import javax.inject.Inject

private const val TAG = "FfmpegCommandExecutor"

interface FfmpegCommandExecutor {
    suspend fun splitVideoCommand(filePath: String)
    suspend fun reverseVideoCommand(filePath: String)
}

class FfmpegCommandExecutorImpl @Inject constructor(
    private val externalMediaDirs: Array<out File>?,
    private val filesDir: File?
) : FfmpegCommandExecutor {

    private lateinit var lastReverseCommand: Array<String>

    private var choice = VideoSteps.Initial

    private var filePath: String? = null

    override suspend fun splitVideoCommand(filePath: String) {
        choice = VideoSteps.Split
        val filePrefix = "split_video"
        val fileExtension = ".mp4"
        val dir = File(externalMediaDirs?.first(), ".VideoSplit")
        if (dir.exists()) deleteDir(dir)
        dir.mkdir()
        val dest = File(dir, "$filePrefix%03d$fileExtension")
        val complexCommand = arrayOf(
            "-i",
            filePath,
            "-c:v",
            "libx264",
            "-crf",
            "22",
            "-map",
            "0",
            "-segment_time",
            "6",
            "-g",
            "9",
            "-sc_threshold",
            "0",
            "-force_key_frames",
            "expr:gte(t,n_forced*6)",
            "-f",
            "segment",
            dest.absolutePath
        )
        execFFmpegBinary(complexCommand)
    }

    private fun reverseVideoCommand() {
        val srcDir = File(externalMediaDirs?.first(), ".VideoSplit")
        val filePrefix = "reverse_video"
        val fileExtension = ".mp4"
        val destDir = File(externalMediaDirs?.first(), "VideoPartsReverse")
        if (destDir.exists()) deleteDir(destDir)
        destDir.mkdir()
        val listFiles = srcDir.listFiles()
        listFiles.map { file ->
            val dest = File(destDir, filePrefix + listFiles.indexOf(file) + fileExtension)
            val command = arrayOf(
                "-i",
                file.absolutePath,
                "-vf",
                "reverse",
                "-af",
                "areverse",
                dest.absolutePath
            )
            if (file == listFiles.last()) lastReverseCommand = command
            execFFmpegBinary(command)
        }
    }

    override suspend fun reverseVideoCommand(filePath: String) {
        val filePrefix = "reverse_video"
        val fileExtension = ".mp4"
        val destDir = File(externalMediaDirs?.first(), "VideoPartsReverse")
        if (destDir.exists()) deleteDir(destDir)
        destDir.mkdir()
        val dest = File(destDir, filePrefix + 0 + fileExtension)
        val command = arrayOf(
            "-i",
            filePath,
            "-vf",
            "reverse",
            "-af",
            "areverse",
            dest.absolutePath
        )
        lastReverseCommand = command
        execFFmpegBinary(command)
    }

    private fun concatVideoCommand() {
        val srcDir = File(externalMediaDirs?.first(), ".VideoPartsReverse")

        if (srcDir.listFiles().size > 1) {
            Arrays.sort(srcDir.listFiles(), LastModifiedFileComparator.LASTMODIFIED_REVERSE)
        }
        val stringBuilder = StringBuilder()
        val filterComplex = StringBuilder()
        filterComplex.append("-filter_complex,")
        srcDir.listFiles().indices.map {
            stringBuilder.append("-i" + "," + srcDir.listFiles()[it].absolutePath + ",")
            filterComplex.append("[").append(it).append(":v").append(it).append("] [").append(it)
                .append(":a").append(it).append("] ")
        }
        filterComplex.append("concat=n=").append(srcDir.listFiles().size).append(":v=1:a=1 [v] [a]")
        val inputCommand = stringBuilder.toString().split(",".toRegex()).toTypedArray()
        val filterCommand = filterComplex.toString().split(",".toRegex()).toTypedArray()
        val filePrefix = "reverse_video"
        val fileExtn = ".mp4"
        var dest = File(filesDir, filePrefix + fileExtn)
        var fileNo = 0
        while (dest.exists()) {
            fileNo++
            dest = File(filesDir, filePrefix + fileNo + fileExtn)
        }
        filePath = dest.absolutePath
        val destinationCommand = arrayOf("-map", "[v]", "-map", "[a]", dest.absolutePath)
        execFFmpegBinary(inputCommand + filterCommand + destinationCommand)
    }

    private fun deleteDir(dir: File): Boolean {
        if (dir.isDirectory) {
            val children = dir.list()
            if (children != null) {
                for (i in children.indices) {
                    val success = deleteDir(File(dir, children[i]))
                    if (!success) {
                        return false
                    }
                }
            }
        }
        return dir.delete()
    }

    private fun execFFmpegBinary(command: Array<String>) {
        try {
            Config.setLogLevel(Level.AV_LOG_TRACE)
            Config.enableLogCallback { message: LogMessage -> Log.e(TAG, message.text) }
            Config.enableStatisticsCallback { newStatistics: Statistics ->
                Log.e(
                    Config.TAG,
                    String.format(
                        "frame: %d, time: %d",
                        newStatistics.videoFrameNumber,
                        newStatistics.time
                    )
                )
                Log.d(TAG, "Started command : ffmpeg " + command.contentToString())
                when (choice) {
                    VideoSteps.Split -> Log.d(TAG, "progress : splitting video $newStatistics")
                    VideoSteps.Reverse -> Log.d(
                        TAG,
                        "progress : reversing splitted videos $newStatistics"
                    )
                    VideoSteps.Concatenate -> Log.d(
                        TAG,
                        "progress : concatenating reversed videos $newStatistics"
                    )
                    else -> Log.d(TAG, "progress : $newStatistics")
                }
                Log.d(TAG, "progress : $newStatistics")
            }

            Log.d(TAG, "Started command : ffmpeg $command")
            val executionId = FFmpeg.executeAsync(
                command
            ) { _: Long, returnCode: Int ->
                if (returnCode == Config.RETURN_CODE_SUCCESS) {
                    Log.d(TAG, "Finished command : ffmpeg " + command.contentToString())
                    when (choice) {
                        VideoSteps.Split -> reverseAndUpdateFlag()
                        VideoSteps.End -> deleteCachePathsAndUpdateFlag()
                        else -> if (command.contentEquals(lastReverseCommand)) {
                            concatenateVideoAndUpdateFlag(command)
                        }
                    }
                }
            }
            Log.e(TAG, "execFFmpegMergeVideo executionId-$executionId")
        } catch (exception: Exception) {
            Log.e(TAG, String.format("Encode video failed %s.", exception.stackTrace));
        }
    }

    private fun reverseAndUpdateFlag() {
        choice = VideoSteps.Reverse
        reverseVideoCommand()
    }

    private fun concatenateVideoAndUpdateFlag(command: Array<String>) {
        if (command.contentEquals(lastReverseCommand)) {
            choice = VideoSteps.Concatenate
            concatVideoCommand()
        }
    }

    private fun deleteCachePathsAndUpdateFlag() {
        val reversePath = File(externalMediaDirs?.first(), ".VideoPartsReverse")
        val splitPath = File(externalMediaDirs?.first(), ".VideoSplit")

        //if (reversePath.exists()) deleteDir(reversePath)
        if (splitPath.exists()) deleteDir(splitPath)

        Log.e(TAG, "Directories removed and FFmpeg finished")

        choice = VideoSteps.Initial

        // TODO: return something
        /* reversedVideoChannel.offer(filePath.orEmpty())
         return reversedVideoChannel.asFlow()*/
    }

}

private enum class VideoSteps {
    Initial,
    Split,
    Reverse,
    Concatenate,
    End
}