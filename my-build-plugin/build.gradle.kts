

apply(from = "../gradle/repos.gradle.kts")
val repoUrl = extra["mavenRepoUrl"] as String

plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("my-build-jvm") {
            id = "my-build-jvm"
            implementationClass = "ru.otus.plugin.BuildPluginJvm"
        }
        register("my-build-kmp") {
            id = "my-build-kmp"
            implementationClass = "ru.otus.plugin.BuildPluginMultiplatform"
        }
    }
}

repositories {
    maven(url = repoUrl)
}

dependencies {
    implementation(libs.pluginKotlin)
}
