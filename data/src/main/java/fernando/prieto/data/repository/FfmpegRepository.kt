package fernando.prieto.data.repository

import fernando.prieto.data.ffmpeg.FfmpegCommandExecutor
import javax.inject.Inject

interface FfmpegRepository {
    suspend fun startFfmpegProcess(filePath: String)
}

class FfmpegRepositoryImpl @Inject constructor(
    private val ffmpegCommandExecutor: FfmpegCommandExecutor
) : FfmpegRepository {

    override suspend fun startFfmpegProcess(filePath: String) {
    ffmpegCommandExecutor.splitVideoCommand(filePath)
        // ffmpegCommandExecutor.reverseVideoCommand(filePath)
    }
}
