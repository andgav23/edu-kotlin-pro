import ru.otus.app.buildMessage
import ru.otus.app.getCurrentTime
import kotlin.test.Test
import kotlin.test.assertEquals

class HelloWorldTest {

    @Test
    fun testHelloWorld() {
        val currentTime = getCurrentTime()
        assertEquals("Hello, Tom, it’s $currentTime now!", buildMessage("Tom",currentTime))
    }
}