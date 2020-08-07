package prieto.fernando.domain.mapper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lprieto/fernando/domain/mapper/LaunchesDomainFilter;", "", "filter", "", "Lprieto/fernando/domain/model/LaunchDomainModel;", "launchesDomainModel", "filterYear", "", "ascendantOrder", "", "domain_debug"})
public abstract interface LaunchesDomainFilter {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<prieto.fernando.domain.model.LaunchDomainModel> filter(@org.jetbrains.annotations.NotNull()
    java.util.List<prieto.fernando.domain.model.LaunchDomainModel> launchesDomainModel, int filterYear, boolean ascendantOrder);
}