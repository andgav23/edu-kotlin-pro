
apply(from = "../gradle/repos.gradle.kts")
val repoUrl = extra["mavenRepoUrl"] as String

dependencyResolutionManagement {
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
