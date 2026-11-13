apply(from = "../gradle/repos.gradle.kts")
val repoUrl = extra["mavenRepoUrl"] as String

dependencyResolutionManagement {
    // Use the repository selected from local.properties in all subprojects.
    @Suppress("UnstableApiUsage")
    repositories {
        maven(url = repoUrl)
    }
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

pluginManagement {
    includeBuild("../my-build-plugin")
}

plugins {
    // Use the Foojay Toolchains plugin to automatically download JDKs required by subprojects.
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

include(":example-kmp")


rootProject.name = "event-billing"
