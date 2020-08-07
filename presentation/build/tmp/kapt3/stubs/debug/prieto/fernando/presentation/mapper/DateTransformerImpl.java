package prieto.fernando.presentation.mapper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0016J\f\u0010\r\u001a\u00020\u0006*\u00020\u000eH\u0002J\f\u0010\r\u001a\u00020\u0006*\u00020\u000fH\u0002J\f\u0010\u0010\u001a\u00020\u0006*\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lprieto/fernando/presentation/mapper/DateTransformerImpl;", "Lprieto/fernando/presentation/mapper/DateTransformer;", "dateTimeProvider", "Lprieto/fernando/presentation/mapper/DateTimeProvider;", "(Lprieto/fernando/presentation/mapper/DateTimeProvider;)V", "dateToDateString", "", "dateTime", "Lorg/joda/time/DateTime;", "getDifferenceOfDays", "isPast", "", "launchDate", "getStringValue", "", "Lorg/joda/time/DateTime$Property;", "getTwoDigitsValue", "presentation_debug"})
public final class DateTransformerImpl implements prieto.fernando.presentation.mapper.DateTransformer {
    private final prieto.fernando.presentation.mapper.DateTimeProvider dateTimeProvider = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String dateToDateString(@org.jetbrains.annotations.NotNull()
    org.joda.time.DateTime dateTime) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getDifferenceOfDays(@org.jetbrains.annotations.NotNull()
    org.joda.time.DateTime dateTime) {
        return null;
    }
    
    @java.lang.Override()
    public boolean isPast(@org.jetbrains.annotations.NotNull()
    org.joda.time.DateTime launchDate) {
        return false;
    }
    
    private final java.lang.String getStringValue(@org.jetbrains.annotations.NotNull()
    org.joda.time.DateTime.Property $this$getStringValue) {
        return null;
    }
    
    private final java.lang.String getStringValue(int $this$getStringValue) {
        return null;
    }
    
    private final java.lang.String getTwoDigitsValue(int $this$getTwoDigitsValue) {
        return null;
    }
    
    @javax.inject.Inject()
    public DateTransformerImpl(@org.jetbrains.annotations.NotNull()
    prieto.fernando.presentation.mapper.DateTimeProvider dateTimeProvider) {
        super();
    }
}