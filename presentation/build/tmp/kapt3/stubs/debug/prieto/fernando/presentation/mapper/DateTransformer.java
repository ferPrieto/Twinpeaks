package prieto.fernando.presentation.mapper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&\u00a8\u0006\n"}, d2 = {"Lprieto/fernando/presentation/mapper/DateTransformer;", "", "dateToDateString", "", "dateTime", "Lorg/joda/time/DateTime;", "getDifferenceOfDays", "isPast", "", "launchDate", "presentation_debug"})
public abstract interface DateTransformer {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String dateToDateString(@org.jetbrains.annotations.NotNull()
    org.joda.time.DateTime dateTime);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getDifferenceOfDays(@org.jetbrains.annotations.NotNull()
    org.joda.time.DateTime dateTime);
    
    public abstract boolean isPast(@org.jetbrains.annotations.NotNull()
    org.joda.time.DateTime launchDate);
}