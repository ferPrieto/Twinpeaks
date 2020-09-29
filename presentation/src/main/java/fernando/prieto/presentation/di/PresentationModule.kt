package fernando.prieto.presentation.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.Reusable
import fernando.prieto.data.di.AppContext
import fernando.prieto.data.ffmpeg.FfmpegCommandExecutor
import fernando.prieto.data.ffmpeg.FfmpegCommandExecutorImpl
import fernando.prieto.data.repository.FfmpegRepository
import fernando.prieto.data.repository.FfmpegRepositoryImpl
import fernando.prieto.presentation.mapper.TextReverser
import fernando.prieto.presentation.mapper.TextReverserImpl

@Module
class PresentationModule {
    @Provides
    @Reusable
    fun provideTextReversed(): TextReverser = TextReverserImpl()

    @Provides
    @Reusable
    fun provideFfmpegRepository(ffmpegCommandExecutor: FfmpegCommandExecutor): FfmpegRepository =
        FfmpegRepositoryImpl(ffmpegCommandExecutor)

    @Provides
    @Reusable
    fun provideFfmpegCommandExecutor(
        @AppContext context: Context
    ): FfmpegCommandExecutor =
        FfmpegCommandExecutorImpl(
            context.externalMediaDirs,
            context.filesDir
        )
}