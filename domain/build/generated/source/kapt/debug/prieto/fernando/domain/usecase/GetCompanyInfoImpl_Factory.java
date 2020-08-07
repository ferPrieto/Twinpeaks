// Generated by Dagger (https://dagger.dev).
package prieto.fernando.domain.usecase;

import dagger.internal.Factory;
import javax.inject.Provider;
import prieto.fernando.domain.SpaceXRepository;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GetCompanyInfoImpl_Factory implements Factory<GetCompanyInfoImpl> {
  private final Provider<SpaceXRepository> spaceXRepositoryProvider;

  public GetCompanyInfoImpl_Factory(Provider<SpaceXRepository> spaceXRepositoryProvider) {
    this.spaceXRepositoryProvider = spaceXRepositoryProvider;
  }

  @Override
  public GetCompanyInfoImpl get() {
    return new GetCompanyInfoImpl(spaceXRepositoryProvider.get());
  }

  public static GetCompanyInfoImpl_Factory create(
      Provider<SpaceXRepository> spaceXRepositoryProvider) {
    return new GetCompanyInfoImpl_Factory(spaceXRepositoryProvider);
  }

  public static GetCompanyInfoImpl newInstance(SpaceXRepository spaceXRepository) {
    return new GetCompanyInfoImpl(spaceXRepository);
  }
}