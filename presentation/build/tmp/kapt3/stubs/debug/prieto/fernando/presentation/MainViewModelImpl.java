package prieto.fernando.presentation;

import java.lang.System;

@kotlinx.coroutines.FlowPreview()
@kotlinx.coroutines.ExperimentalCoroutinesApi()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lprieto/fernando/presentation/MainViewModelImpl;", "Lprieto/fernando/presentation/MainViewModel;", "textReverser", "Lprieto/fernando/presentation/mapper/TextReverser;", "(Lprieto/fernando/presentation/mapper/TextReverser;)V", "recordVideo", "Landroidx/lifecycle/MutableLiveData;", "", "getRecordVideo", "()Landroidx/lifecycle/MutableLiveData;", "reversedText", "", "getReversedText", "recordVideoClicked", "reverseText", "textSelected", "presentation_debug"})
public final class MainViewModelImpl extends prieto.fernando.presentation.MainViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> reversedText = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<kotlin.Unit> recordVideo = null;
    private final prieto.fernando.presentation.mapper.TextReverser textReverser = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.MutableLiveData<java.lang.String> getReversedText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.MutableLiveData<kotlin.Unit> getRecordVideo() {
        return null;
    }
    
    @java.lang.Override()
    public void reverseText(@org.jetbrains.annotations.NotNull()
    java.lang.String textSelected) {
    }
    
    @java.lang.Override()
    public void recordVideoClicked() {
    }
    
    @javax.inject.Inject()
    public MainViewModelImpl(@org.jetbrains.annotations.NotNull()
    prieto.fernando.presentation.mapper.TextReverser textReverser) {
        super();
    }
}