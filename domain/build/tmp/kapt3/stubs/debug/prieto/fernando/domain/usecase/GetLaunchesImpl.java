package prieto.fernando.domain.usecase;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J-\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lprieto/fernando/domain/usecase/GetLaunchesImpl;", "Lprieto/fernando/domain/usecase/GetLaunches;", "spaceXRepository", "Lprieto/fernando/domain/SpaceXRepository;", "launchesDomainFilter", "Lprieto/fernando/domain/mapper/LaunchesDomainFilter;", "(Lprieto/fernando/domain/SpaceXRepository;Lprieto/fernando/domain/mapper/LaunchesDomainFilter;)V", "execute", "Lkotlinx/coroutines/flow/Flow;", "", "Lprieto/fernando/domain/model/LaunchDomainModel;", "yearFilterCriteria", "", "ascendantOrder", "", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_debug"})
public final class GetLaunchesImpl implements prieto.fernando.domain.usecase.GetLaunches {
    private final prieto.fernando.domain.SpaceXRepository spaceXRepository = null;
    private final prieto.fernando.domain.mapper.LaunchesDomainFilter launchesDomainFilter = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object execute(int yearFilterCriteria, boolean ascendantOrder, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<prieto.fernando.domain.model.LaunchDomainModel>>> p2) {
        return null;
    }
    
    @javax.inject.Inject()
    public GetLaunchesImpl(@org.jetbrains.annotations.NotNull()
    prieto.fernando.domain.SpaceXRepository spaceXRepository, @org.jetbrains.annotations.NotNull()
    prieto.fernando.domain.mapper.LaunchesDomainFilter launchesDomainFilter) {
        super();
    }
}