pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("com.android.application") version "8.6.0"
        id("org.jetbrains.kotlin.android") version "1.9.22"
        id("com.google.dagger.hilt.android") version "2.48"
        id("org.jetbrains.kotlin.kapt") version "1.9.22"
        id("org.jetbrains.kotlin.plugin.serialization") version "1.9.22"
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Rekovi"
include(":app")
