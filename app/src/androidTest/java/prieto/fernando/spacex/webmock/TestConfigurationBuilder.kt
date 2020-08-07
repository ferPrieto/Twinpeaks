package prieto.fernando.spacex.webmock

import androidx.test.platform.app.InstrumentationRegistry
import prieto.fernando.data_api.di.NetworkModule
import prieto.fernando.spacex.BuildConfig
import prieto.fernando.twinpeaks.TwinpeaksApp
import prieto.fernando.twinpeaks.di.AppComponent
import prieto.fernando.spacex.di.DaggerAppComponent

class TestConfigurationBuilder {
    private val baseUrl: String = "http://127.0.0.1:${BuildConfig.PORT}"

    fun inject() {
        appComponent {
            networkModule(NetworkModule(baseUrl))
        }.inject(requireTestedApplication())
    }
}

fun injectTestConfiguration(block: TestConfigurationBuilder.() -> Unit) {
    TestConfigurationBuilder().apply(block).inject()
}

private fun appComponent(block: DaggerAppComponent.Builder.() -> Unit = {}): AppComponent =
    DaggerAppComponent.builder().apply(block).build()

private fun requireTestedApplication() =
    (InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as TwinpeaksApp)