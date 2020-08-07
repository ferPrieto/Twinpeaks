package prieto.fernando.twinpeaks

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import prieto.fernando.spacex.di.DaggerAppComponent

open class TwinpeaksApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder()
            .build()
}
