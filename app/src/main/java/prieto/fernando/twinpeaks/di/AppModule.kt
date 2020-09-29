package prieto.fernando.twinpeaks.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import fernando.prieto.data.di.AppContext
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {
    @Provides
    @Singleton
    @AppContext
    fun provideContext(): Context = application.applicationContext
}

