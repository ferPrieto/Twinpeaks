package prieto.fernando.presentation.di

import dagger.Module
import dagger.Provides
import dagger.Reusable
import prieto.fernando.presentation.mapper.TextReverser
import prieto.fernando.presentation.mapper.TextReverserImpl

@Module
class PresentationModule {
    @Provides
    @Reusable
    fun provideTextReversed(): TextReverser = TextReverserImpl()
}