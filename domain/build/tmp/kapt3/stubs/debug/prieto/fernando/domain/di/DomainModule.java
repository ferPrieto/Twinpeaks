package prieto.fernando.domain.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007\u00a8\u0006\f"}, d2 = {"Lprieto/fernando/domain/di/DomainModule;", "", "()V", "provideGetCompanyInfo", "Lprieto/fernando/domain/usecase/GetCompanyInfo;", "spaceXRepository", "Lprieto/fernando/domain/SpaceXRepository;", "provideGetLaunches", "Lprieto/fernando/domain/usecase/GetLaunches;", "filter", "Lprieto/fernando/domain/mapper/LaunchesDomainFilter;", "provideLaunchesDomainFilter", "domain_debug"})
@dagger.Module()
public final class DomainModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Reusable()
    @dagger.Provides()
    public final prieto.fernando.domain.usecase.GetLaunches provideGetLaunches(@org.jetbrains.annotations.NotNull()
    prieto.fernando.domain.SpaceXRepository spaceXRepository, @org.jetbrains.annotations.NotNull()
    prieto.fernando.domain.mapper.LaunchesDomainFilter filter) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Reusable()
    @dagger.Provides()
    public final prieto.fernando.domain.usecase.GetCompanyInfo provideGetCompanyInfo(@org.jetbrains.annotations.NotNull()
    prieto.fernando.domain.SpaceXRepository spaceXRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Reusable()
    @dagger.Provides()
    public final prieto.fernando.domain.mapper.LaunchesDomainFilter provideLaunchesDomainFilter() {
        return null;
    }
    
    public DomainModule() {
        super();
    }
}