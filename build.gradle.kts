
group = "ru.otus.otuskotlin"
version = "0.0.1"

tasks.register("buildAll") {
    group = "build"
    description = "Собирает все вложенные сборки composite-проекта"
    dependsOn(
        gradle.includedBuild("lessons").task(":hello-world:build"),
        gradle.includedBuild("event-billing").task(":example-kmp:build"),
    )
}

