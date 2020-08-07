// Generated by Dagger (https://dagger.dev).
package prieto.fernando.domain.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import prieto.fernando.domain.SpaceXRepository;
import prieto.fernando.domain.usecase.GetCompanyInfo;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DomainModule_ProvideGetCompanyInfoFactory implements Factory<GetCompanyInfo> {
  private final DomainModule module;

  private final Provider<SpaceXRepository> spaceXRepositoryProvider;

  public DomainModule_ProvideGetCompanyInfoFactory(DomainModule module,
      Provider<SpaceXRepository> spaceXRepositoryProvider) {
    this.module = module;
    this.spaceXRepositoryProvider = spaceXRepositoryProvider;
  }

  @Override
  public GetCompanyInfo get() {
    return provideGetCompanyInfo(module, spaceXRepositoryProvider.get());
  }

  public static DomainModule_ProvideGetCompanyInfoFactory create(DomainModule module,
      Provider<SpaceXRepository> spaceXRepositoryProvider) {
    return new DomainModule_ProvideGetCompanyInfoFactory(module, spaceXRepositoryProvider);
  }

  public static GetCompanyInfo provideGetCompanyInfo(DomainModule instance,
      SpaceXRepository spaceXRepository) {
    return Preconditions.checkNotNull(instance.provideGetCompanyInfo(spaceXRepository), "Cannot return null from a non-@Nullable @Provides method");
  }
}
