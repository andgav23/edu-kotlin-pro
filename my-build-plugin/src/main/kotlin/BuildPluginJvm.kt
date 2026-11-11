package ru.otus.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.repositories
import java.io.File
import java.util.Properties

@Suppress("unused")
internal class BuildPluginJvm : Plugin<Project> {

    override fun apply(project: Project) = with(project) {
        pluginManager.apply("org.jetbrains.kotlin.jvm")
        group = rootProject.group
        version = rootProject.version
        val repoUrl = localMavenRepoUrl(rootDir)
        repositories {
            maven { setUrl(repoUrl) }
        }
    }

    private fun localMavenRepoUrl(baseDir: File): String {
        val localProps = Properties().apply {
            var dir: File? = baseDir
            while (dir != null && !File(dir, "local.properties").isFile) dir = dir.parentFile
            val f = dir?.let { File(it, "local.properties") }
            if (f != null && f.isFile) load(f.inputStream())
        }
        return localProps.getProperty("maven.repos.url")
            ?: "https://repo.maven.apache.org/maven2"
    }
}