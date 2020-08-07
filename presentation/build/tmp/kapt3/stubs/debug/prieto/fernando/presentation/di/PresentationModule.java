package prieto.fernando.presentation.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0007\u00a8\u0006\r"}, d2 = {"Lprieto/fernando/presentation/di/PresentationModule;", "", "()V", "provideCompanyInfoDomainToUiModelMapper", "Lprieto/fernando/presentation/mapper/CompanyInfoDomainToUiModelMapper;", "provideDateTimeProvider", "Lprieto/fernando/presentation/mapper/DateTimeProvider;", "provideDateTransformer", "Lprieto/fernando/presentation/mapper/DateTransformer;", "dateTimeProvider", "provideLaunchesDomainToUiModelMapper", "Lprieto/fernando/presentation/mapper/LaunchesDomainToUiModelMapper;", "dateTransformer", "presentation_debug"})
@dagger.Module()
public final class PresentationModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Reusable()
    @dagger.Provides()
    public final prieto.fernando.presentation.mapper.LaunchesDomainToUiModelMapper provideLaunchesDomainToUiModelMapper(@org.jetbrains.annotations.NotNull()
    prieto.fernando.presentation.mapper.DateTransformer dateTransformer) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Reusable()
    @dagger.Provides()
    public final prieto.fernando.presentation.mapper.DateTransformer provideDateTransformer(@org.jetbrains.annotations.NotNull()
    prieto.fernando.presentation.mapper.DateTimeProvider dateTimeProvider) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Reusable()
    @dagger.Provides()
    public final prieto.fernando.presentation.mapper.DateTimeProvider provideDateTimeProvider() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Reusable()
    @dagger.Provides()
    public final prieto.fernando.presentation.mapper.CompanyInfoDomainToUiModelMapper provideCompanyInfoDomainToUiModelMapper() {
        return null;
    }
    
    public PresentationModule() {
        super();
    }
}