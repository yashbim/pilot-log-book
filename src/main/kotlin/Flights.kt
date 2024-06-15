import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

data class Flight(
    val uuid: String,
    val flightMake: String,
    val flightModel: String,
    val flightReg: String,
    val flightTakeOffAirport: String,
    val flightTakeOffDate: LocalDate,
    val flightTakeOffTime: LocalTime,
    val flightLandingAirport: String,
    val flightLandingDate: LocalDate,
    val flightLandingTime: LocalTime
) {
    fun displayInput() {
        val uuidStr = uuid.toString()
        println("Flight ID : $uuid\n${"-".repeat(uuidStr.length + 12)}")
        println("AIRCRAFT DATA" +
                "\n Make          : $flightMake" +
                "\n Model         : $flightModel" +
                "\n Registration  : $flightReg")
        println("TAKEOFF DATA" +
                "\n Airport       : $flightTakeOffAirport" +
                "\n Date          : $flightTakeOffDate" +
                "\n Time          : $flightTakeOffTime")
        println("LANDING DATA" +
                "\n Airport       : $flightLandingAirport" +
                "\n Date          : $flightLandingDate" +
                "\n Time          : $flightLandingTime")
    }
}

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
