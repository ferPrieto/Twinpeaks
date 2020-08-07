package prieto.fernando.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tH&R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lprieto/fernando/presentation/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "recordVideo", "Landroidx/lifecycle/LiveData;", "", "getRecordVideo", "()Landroidx/lifecycle/LiveData;", "reversedText", "", "getReversedText", "recordVideoClicked", "reverseText", "textSelected", "presentation_debug"})
public abstract class MainViewModel extends androidx.lifecycle.ViewModel {
    
    public abstract void reverseText(@org.jetbrains.annotations.NotNull()
    java.lang.String textSelected);
    
    public abstract void recordVideoClicked();
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.lang.String> getReversedText();
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<kotlin.Unit> getRecordVideo();
    
    public MainViewModel() {
        super();
    }
}