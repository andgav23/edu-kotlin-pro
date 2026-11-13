import kotlinx.datetime.LocalDateTime

data class Event(
    val id: String,
    val type: String,
    val createAt: LocalDateTime
)
