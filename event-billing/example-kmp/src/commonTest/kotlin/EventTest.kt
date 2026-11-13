package ru.otus.otuskotlin.kmp

import Event
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Clock

class EventTest {

    @Test
    fun testEvent() {
        val currentTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

        val event = Event("1", "Order", currentTime)

        assertEquals("1", event.id)
        assertEquals("Order", event.type)
        assertEquals(currentTime, event.createAt)
    }
}
