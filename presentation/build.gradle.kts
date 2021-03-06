plugins {
    id("com.android.library")
    id("prieto.fernando.android.plugin")
}

dependencies {
    implementation(project(ProjectModules.data))

    api(Dependencies.Dagger.dagger)
    api(Dependencies.Dagger.daggerAndroid)
    api(Dependencies.Dagger.daggerAndroidSupport)

    implementation(Dependencies.AndroidX.Navigation.fragmentKtx)
    implementation(Dependencies.AndroidX.Navigation.uiKtx)
    implementation(Dependencies.AndroidX.lifecycleLivedataKtx)
    implementation(Dependencies.timber)
}