import ru.otus.app.buildMessage
import kotlin.test.Test
import kotlin.test.assertEquals

class HelloWorldTest {

    @Test
    fun testHelloWorld() {
        assertEquals("Hello, Kotlin!", buildMessage("Kotlin"))
    }
}