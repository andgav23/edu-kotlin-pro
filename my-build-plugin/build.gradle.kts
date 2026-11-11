

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
//        register("build-kmp") {
//            id = "build-kmp"
//            implementationClass = "ru.otus.otuskotlin.marketplace.plugin.BuildPluginMultiplatform"
//        }
    }
}

repositories {
    maven(url = repoUrl)
}

dependencies {
    implementation(libs.pluginKotlin)
}

//subprojects {
//    group = rootProject.group
//    version = rootProject.version
//    repositories {
//        mavenCentral()
//    }
//}