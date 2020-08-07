// Generated by Dagger (https://dagger.dev).
package prieto.fernando.core.android;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class InjectingViewModelFactory_Factory implements Factory<InjectingViewModelFactory> {
  private final Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> viewModelsProvider;

  public InjectingViewModelFactory_Factory(
      Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> viewModelsProvider) {
    this.viewModelsProvider = viewModelsProvider;
  }

  @Override
  public InjectingViewModelFactory get() {
    return new InjectingViewModelFactory(viewModelsProvider.get());
  }

  public static InjectingViewModelFactory_Factory create(
      Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> viewModelsProvider) {
    return new InjectingViewModelFactory_Factory(viewModelsProvider);
  }

  public static InjectingViewModelFactory newInstance(
      Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModels) {
    return new InjectingViewModelFactory(viewModels);
  }
}
