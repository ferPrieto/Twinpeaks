plugins {
    id("com.android.library")
    id("prieto.fernando.android.plugin")
}

dependencies {
    api(Dependencies.Dagger.dagger)
    api(Dependencies.Dagger.daggerAndroid)
    api(Dependencies.Dagger.daggerAndroidSupport)

    implementation(Dependencies.FFmpeg.ffMpeg)
    implementation(Dependencies.commonsIO)
    implementation(Dependencies.timber)
}