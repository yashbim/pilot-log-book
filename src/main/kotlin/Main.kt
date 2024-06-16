import java.time.LocalDate
import java.time.LocalTime

fun main() {
    val flights = mutableListOf<Flight>()

    while (true) {
        println(
            "\n 1  : Add Flight" +
                    "\n 2  : Delete Flight" +
                    "\n 3  : Update Flight" +
                    "\n 4  : View Flights" +
                    "\n q  : Quit"
        )
        println("Enter Option :")
        val option = readln()

        when (option) {
            "1" -> addFlight(flights) // calls the addFlight function to add a flight
            "2" -> deleteFlight(flights) // calls the deleteFlight function to delete a flight
            "3" -> updateFlight(flights) // calls the updateFlight function to update a flight
            "4" -> viewFlights(flights) // calls the viewFlights function to view all flights
            "q" -> break // quits program
            else -> println("Invalid Input")
        }
    }

    // Display all flight records
    println("\nAll Entered Flight Records:")
    flights.forEach { flight ->
        displayInput(flight)
        println()
    }
}
