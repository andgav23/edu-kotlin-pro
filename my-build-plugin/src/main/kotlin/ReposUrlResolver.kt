package ru.otus.plugin

import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.extra
import java.io.File

@Suppress("unused")
internal object ReposUrlResolver {

    fun resolve(project: Project): String {
        var dir: File? = project.rootDir
        while (dir != null && !File(dir, "gradle/repos.gradle.kts").isFile) dir = dir.parentFile
        val script = File(dir ?: project.rootDir, "gradle/repos.gradle.kts")
        project.apply(from = script)
        return project.extra["mavenRepoUrl"] as String
    }
}