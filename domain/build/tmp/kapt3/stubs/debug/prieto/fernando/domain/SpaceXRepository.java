package prieto.fernando.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lprieto/fernando/domain/SpaceXRepository;", "", "getAllLaunches", "Lkotlinx/coroutines/flow/Flow;", "", "Lprieto/fernando/domain/model/LaunchDomainModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCompanyInfo", "Lprieto/fernando/domain/model/CompanyInfoDomainModel;", "domain_debug"})
public abstract interface SpaceXRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCompanyInfo(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<prieto.fernando.domain.model.CompanyInfoDomainModel>> p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllLaunches(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<prieto.fernando.domain.model.LaunchDomainModel>>> p0);
}