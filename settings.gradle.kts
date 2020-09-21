rootProject.name = "Twinpeaks"
rootProject.buildFileName = "build.gradle.kts"

include(
    ":app",
    ProjectModules.core,
    ProjectModules.presentation,
    ProjectModules.coreAndroidTest
)
