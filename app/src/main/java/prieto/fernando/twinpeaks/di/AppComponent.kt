package prieto.fernando.twinpeaks.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import fernando.prieto.presentation.di.PresentationModule
import prieto.fernando.core.di.FragmentBindingModule
import prieto.fernando.core.di.ViewModelBindingModule
import prieto.fernando.twinpeaks.TwinpeaksApp
import javax.inject.Singleton

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        PresentationModule::class,
        MainActivityModule::class,
        ViewModelBindingModule::class,
        FragmentBindingModule::class
    ]
)
@Singleton
interface AppComponent : AndroidInjector<TwinpeaksApp>
