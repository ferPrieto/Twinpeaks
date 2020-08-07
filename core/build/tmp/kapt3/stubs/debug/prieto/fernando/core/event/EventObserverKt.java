package prieto.fernando.core.event;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aM\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\b\u0004\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\n0\tH\u0087\b\u001aA\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\n0\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0087\b\u00a8\u0006\r"}, d2 = {"observeEvent", "Landroidx/lifecycle/Observer;", "E", "Lprieto/fernando/core/event/Event;", "T", "Landroidx/lifecycle/LiveData;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onChanged", "Lkotlin/Function1;", "", "observeUnitEvent", "Lkotlin/Function0;", "core_debug"})
public final class EventObserverKt {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.MainThread()
    public static final <E extends prieto.fernando.core.event.Event<? extends T>, T extends java.lang.Object>androidx.lifecycle.Observer<E> observeEvent(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<E> $this$observeEvent, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> onChanged) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.MainThread()
    public static final <E extends prieto.fernando.core.event.Event<? extends kotlin.Unit>>androidx.lifecycle.Observer<E> observeUnitEvent(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<E> $this$observeUnitEvent, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onChanged) {
        return null;
    }
}