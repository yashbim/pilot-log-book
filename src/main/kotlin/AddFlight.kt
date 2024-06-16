import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeParseException
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
    val flightTakeOffDate: LocalDate? = null
    val flightTakeOffTime: LocalTime? = null

    while (true){
        println("TakeOff Date (yyyy-mm-dd):")
        try {
            val flightTakeOffDate = LocalDate.parse(readln())
            break
        } catch (e: DateTimeParseException){
            println("Invalid date format. Use YYYY-MM-DD")
        }
    } //takeoff date entry and validation

    while (true){
        println("TakeOff Time (HH:mm):")
        try {
            val flightTakeOffTime = LocalTime.parse(readln())
            break
        } catch (e: DateTimeParseException){
            println("Invalid time format. Use HH:MM")
        }
    } //takeoff time entry and validation

    // LANDING
    println("LANDING DATA ENTRY")
    println("Landing Airport:")
    val flightLandingAirport = readln()
    val flightLandingDate: LocalDate? = null
    val flightLandingTime: LocalTime? = null

    while (true){
        println("Landing Date (yyyy-mm-dd):")
        try {
            val flightLandingDate = LocalDate.parse(readln())
            break
        } catch (e: DateTimeParseException){
            println("Invalid date format. Use YYYY-MM-DD")}
    } //landing date entry and validation

    while (true){
        println("Landing Time (HH:mm):")
        try {
            val flightLandingTime = LocalTime.parse(readln())
            break
        } catch (e: DateTimeParseException) {
            println("Invalid time format. Use HH:MM")
        }
    } //landing date entry and validation

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
