// Generated by Dagger (https://dagger.dev).
package prieto.fernando.domain.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import prieto.fernando.domain.SpaceXRepository;
import prieto.fernando.domain.mapper.LaunchesDomainFilter;
import prieto.fernando.domain.usecase.GetLaunches;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DomainModule_ProvideGetLaunchesFactory implements Factory<GetLaunches> {
  private final DomainModule module;

  private final Provider<SpaceXRepository> spaceXRepositoryProvider;

  private final Provider<LaunchesDomainFilter> filterProvider;

  public DomainModule_ProvideGetLaunchesFactory(DomainModule module,
      Provider<SpaceXRepository> spaceXRepositoryProvider,
      Provider<LaunchesDomainFilter> filterProvider) {
    this.module = module;
    this.spaceXRepositoryProvider = spaceXRepositoryProvider;
    this.filterProvider = filterProvider;
  }

  @Override
  public GetLaunches get() {
    return provideGetLaunches(module, spaceXRepositoryProvider.get(), filterProvider.get());
  }

  public static DomainModule_ProvideGetLaunchesFactory create(DomainModule module,
      Provider<SpaceXRepository> spaceXRepositoryProvider,
      Provider<LaunchesDomainFilter> filterProvider) {
    return new DomainModule_ProvideGetLaunchesFactory(module, spaceXRepositoryProvider, filterProvider);
  }

  public static GetLaunches provideGetLaunches(DomainModule instance,
      SpaceXRepository spaceXRepository, LaunchesDomainFilter filter) {
    return Preconditions.checkNotNull(instance.provideGetLaunches(spaceXRepository, filter), "Cannot return null from a non-@Nullable @Provides method");
  }
}
