package fernando.prieto.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fernando.prieto.data.repository.FfmpegRepository
import fernando.prieto.presentation.mapper.TextReverser
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

abstract class CaptureVideoViewModel : ViewModel() {
    abstract fun reverseText(textSelected: String)
    abstract fun recordVideoClicked()
    abstract fun startVideoProcessing(path: String)

    abstract val reversedText: LiveData<String>
    abstract val recordVideo: LiveData<Unit>
}

@ExperimentalCoroutinesApi
class CaptureVideoModelImpl @Inject constructor(
    private val textReverser: TextReverser,
    private val ffmpegRepository: FfmpegRepository
) : CaptureVideoViewModel() {
    override val reversedText = MutableLiveData<String>()
    override val recordVideo = MutableLiveData<Unit>()

    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        Timber.e(exception)
    }

    override fun reverseText(textSelected: String) {
        textReverser.reverse(textSelected).let { textReversed ->
            reversedText.postValue(textReversed)
        }
    }

    override fun recordVideoClicked() {
        recordVideo.postValue(Unit)
    }

    override fun startVideoProcessing(path: String) {
        viewModelScope.launch(errorHandler) {
            ffmpegRepository.startFfmpegProcess(path)
        }
    }
}