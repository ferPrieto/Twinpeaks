package prieto.fernando.twinpeaks.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import prieto.fernando.core.di.FragmentKey
import prieto.fernando.core.di.ViewModelKey
import prieto.fernando.presentation.MainViewModel
import prieto.fernando.presentation.MainViewModelImpl
import prieto.fernando.twinpeaks.ui.MainActivity
import prieto.fernando.twinpeaks.ui.fragment.InputTextFragment

@Module
internal abstract class MainActivityModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @Binds
    @IntoMap
    @FragmentKey(InputTextFragment::class)
    abstract fun inputTextFragment(inputTextFragment: InputTextFragment): Fragment

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun inputTextViewModel(viewModel: MainViewModelImpl): ViewModel
}
