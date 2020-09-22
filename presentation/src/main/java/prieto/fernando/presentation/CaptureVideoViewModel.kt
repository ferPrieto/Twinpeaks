package prieto.fernando.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import prieto.fernando.presentation.mapper.TextReverser
import javax.inject.Inject

abstract class CaptureVideoViewModel : ViewModel() {
    abstract fun reverseText(textSelected: String)
    abstract fun recordVideoClicked()

    abstract val reversedText: LiveData<String>
    abstract val recordVideo: LiveData<Unit>
}

@ExperimentalCoroutinesApi
@FlowPreview
class CaptureVideoModelImpl @Inject constructor(
    private val textReverser: TextReverser
) : CaptureVideoViewModel() {
    override val reversedText = MutableLiveData<String>()
    override val recordVideo = MutableLiveData<Unit>()

    override fun reverseText(textSelected: String) {
        textReverser.reverse(textSelected).let { textReversed ->
            reversedText.postValue(textReversed)
        }
    }

    override fun recordVideoClicked() {
        recordVideo.postValue(Unit)
    }
}