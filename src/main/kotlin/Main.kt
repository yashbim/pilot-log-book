import java.time.LocalDate
import java.time.LocalTime

fun main() {
    val flights = mutableListOf<Flight>()

    while (true) {
        println(
            "\n 1  : Add Flight" +
            "\n 2  : Delete Flight" +
            "\n 3  : Update Flight" +
            "\n q  : Quit"
        )
        println("Enter Option :")
        val option = readln()

        when (option) {
            "1" -> addFlight(flights) // calls the addFlight function to add a flight
            "2" -> { /* calls the deleteFlight function to delete a flight */ }
            "3" -> { /* calls the updateFlight function to update a flight */ }
            "q" -> break // quits program
            else -> println("Invalid Input")
        }
    }

    // Display all flight records
    println("\nAll Entered Flight Records:")
    flights.forEach { flight ->
        flight.displayInput()
        println()
    }
}
