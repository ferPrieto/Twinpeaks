package prieto.fernando.twinpeaks.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import fernando.prieto.presentation.CaptureVideoModelImpl
import fernando.prieto.presentation.CaptureVideoViewModel
import prieto.fernando.core.di.FragmentKey
import prieto.fernando.core.di.ViewModelKey
import prieto.fernando.twinpeaks.ui.MainActivity
import prieto.fernando.twinpeaks.ui.fragment.CaptureVideoFragment

@Module
internal abstract class MainActivityModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @Binds
    @IntoMap
    @FragmentKey(CaptureVideoFragment::class)
    abstract fun bindCaptureVideoFragment(captureVideoFragment: CaptureVideoFragment): Fragment

    @Binds
    @IntoMap
    @ViewModelKey(CaptureVideoViewModel::class)
    abstract fun bindCaptureVideoViewModel(captureVideoModelImpl: CaptureVideoModelImpl): ViewModel
}
