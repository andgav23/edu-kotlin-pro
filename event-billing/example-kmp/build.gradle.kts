
plugins {
    id("my-build-kmp")
}

//plugins {
//    kotlin("multiplatform")
//}

kotlin {
    jvm ()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinxDatetime)
        }
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}