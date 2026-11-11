package ru.otus.app

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock


fun buildMessage(name: String, currentTime: LocalDateTime): String = "Hello, $name, it’s $currentTime now!"

fun getCurrentTime(): LocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

fun main() {
    val name = "Kotlin"
    println(buildMessage(name,getCurrentTime()))

    getCurrentTime()
}

