import org.gradle.internal.extensions.core.extra
import java.io.File
import java.util.Properties

// Скрипт для управлениям репозиториями зависимостей из local.properties
// в нужное место подключаем через:
//      (from = "../gradle/repos.gradle.kts")
//      val repoUrl = extra["mavenRepoUrl"] as String

@Suppress("unresolved_reference")
val localProps = Properties().apply {
    var dir: File? = rootDir
    while (dir != null && !File(dir, "local.properties").isFile) dir = dir.parentFile
    val f = dir?.let { File(it, "local.properties") }
    if (f != null && f.isFile) load(f.inputStream())
}

extra["mavenRepoUrl"] = localProps.getProperty("maven.repos.url")
    ?: "https://repo.maven.apache.org/maven2"