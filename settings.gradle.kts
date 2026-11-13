apply(from = "gradle/repos.gradle.kts")
val repoUrl = extra["mavenRepoUrl"] as String

dependencyResolutionManagement {
    // Use the repository selected from local.properties in all subprojects.
    @Suppress("UnstableApiUsage")
    repositories {
        maven(url = repoUrl)
    }
}

plugins {
    // Use the Foojay Toolchains plugin to automatically download JDKs required by subprojects.
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

includeBuild("lessons")
includeBuild("my-build-plugin")
includeBuild("event-billing")

rootProject.name = "edu-kotlin-pro"
