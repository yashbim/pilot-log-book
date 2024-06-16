import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

fun addFlight(flights: MutableList<Flight>) {
    // Aircraft details
    println("Aircraft Make :")
    val flightMake = readln()
    println("Aircraft Model :")
    val flightModel = readln()
    println("Aircraft Registration :")
    val flightReg = readln()

    // TAKE OFF
    println("TAKE OFF DATA ENTRY")
    println("TakeOff Airport:")
    val flightTakeOffAirport = readln()
    println("TakeOff Date (yyyy-mm-dd):")
    val flightTakeOffDate = LocalDate.parse(readln())
    println("TakeOff Time (HH:mm):")
    val flightTakeOffTime = LocalTime.parse(readln())

    // LANDING
    println("LANDING DATA ENTRY")
    println("Landing Airport:")
    val flightLandingAirport = readln()
    println("Landing Date (yyyy-mm-dd):")
    val flightLandingDate = LocalDate.parse(readln())
    println("Landing Time (HH:mm):")
    val flightLandingTime = LocalTime.parse(readln())

    val uuid = UUID.randomUUID().toString() // random trx uuid

    val flight = Flight(
        uuid,
        flightMake,
        flightModel,
        flightReg,
        flightTakeOffAirport,
        flightTakeOffDate,
        flightTakeOffTime,
        flightLandingAirport,
        flightLandingDate,
        flightLandingTime
    )

    flights.add(flight)
    println("Flight added successfully!")
}

fun displayInput(flight: Flight) {
    val uuidStr = flight.uuid.toString()
    println("Flight ID : ${flight.uuid}\n${"-".repeat(uuidStr.length + 12)}")
    println("AIRCRAFT DATA" +
            "\n Make          : ${flight.flightMake}" +
            "\n Model         : ${flight.flightModel}" +
            "\n Registration  : ${flight.flightReg}")
    println("TAKEOFF DATA" +
            "\n Airport       : ${flight.flightTakeOffAirport}" +
            "\n Date          : ${flight.flightTakeOffDate}" +
            "\n Time          : ${flight.flightTakeOffTime}")
    println("LANDING DATA" +
            "\n Airport       : ${flight.flightLandingAirport}" +
            "\n Date          : ${flight.flightLandingDate}" +
            "\n Time          : ${flight.flightLandingTime}")
}
