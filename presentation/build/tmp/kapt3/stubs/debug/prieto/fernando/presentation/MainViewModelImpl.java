package prieto.fernando.presentation;

import java.lang.System;

@kotlinx.coroutines.FlowPreview()
@kotlinx.coroutines.ExperimentalCoroutinesApi()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tH\u0016R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lprieto/fernando/presentation/MainViewModelImpl;", "Lprieto/fernando/presentation/MainViewModel;", "()V", "recordVideo", "Landroidx/lifecycle/MutableLiveData;", "", "getRecordVideo", "()Landroidx/lifecycle/MutableLiveData;", "reversedText", "", "getReversedText", "recordVideoClicked", "reverseText", "textSelected", "presentation_debug"})
public final class MainViewModelImpl extends prieto.fernando.presentation.MainViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> reversedText = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<kotlin.Unit> recordVideo = null;
    
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
    public MainViewModelImpl() {
        super();
    }
}