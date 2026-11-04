package ru.otus.app

fun buildMessage(name: String): String = "Hello, $name!"

fun main() {
    val name = "Kotlin"
    val message = buildMessage(name)
    println(message)
}

