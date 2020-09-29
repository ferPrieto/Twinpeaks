rootProject.name = "Twinpeaks"
rootProject.buildFileName = "build.gradle.kts"

include(
    ":app",
    ProjectModules.core,
    ProjectModules.coreAndroidTest,
    ProjectModules.data,
    ProjectModules.presentation
)
