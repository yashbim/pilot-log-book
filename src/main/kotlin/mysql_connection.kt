import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

fun getConnection(): Connection? {
    val jdbcUrl = "jdbc:mysql://localhost:3306/pilot_log_book"
    val username = "root"
    val password = "Abc@1234"

    return try {
        DriverManager.getConnection(jdbcUrl, username, password)
    } catch (e: SQLException) {
        e.printStackTrace()
        null
    }
}
