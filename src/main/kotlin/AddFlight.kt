import java.sql.SQLException
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
    var flightTakeOffDate: LocalDate? = null
    var flightTakeOffTime: LocalTime? = null

    while (true){
        println("TakeOff Date (yyyy-mm-dd):")
        try {
            flightTakeOffDate = LocalDate.parse(readln())
            break
        } catch (e: DateTimeParseException){
            println("Invalid date format. Use YYYY-MM-DD")
        }
    } //takeoff date entry and validation

    while (true){
        println("TakeOff Time (HH:mm):")
        try {
            flightTakeOffTime = LocalTime.parse(readln())
            break
        } catch (e: DateTimeParseException){
            println("Invalid time format. Use HH:MM")
        }
    } //takeoff time entry and validation

    // LANDING
    println("LANDING DATA ENTRY")
    println("Landing Airport:")
    val flightLandingAirport = readln()
    var flightLandingDate: LocalDate? = null
    var flightLandingTime: LocalTime? = null

    while (true){
        println("Landing Date (yyyy-mm-dd):")
        try {
            flightLandingDate = LocalDate.parse(readln())
            break
        } catch (e: DateTimeParseException){
            println("Invalid date format. Use YYYY-MM-DD")}
    } //landing date entry and validation

    while (true){
        println("Landing Time (HH:mm):")
        try {
            flightLandingTime = LocalTime.parse(readln())
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
    displayInput(flight)
    insertDB(flight)
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

fun insertDB(flight: Flight) {
    val sql = """
        INSERT INTO flights (uuid, flightMake, flightModel, flightReg, flightTakeOffAirport, flightTakeOffDate, flightTakeOffTime, flightLandingAirport, flightLandingDate, flightLandingTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    """

    try {
        val connection = getConnection()
        val preparedStatement = connection!!.prepareStatement(sql)

        preparedStatement.setString(1, flight.uuid)
        preparedStatement.setString(2, flight.flightMake)
        preparedStatement.setString(3, flight.flightModel)
        preparedStatement.setString(4, flight.flightReg)
        preparedStatement.setString(5, flight.flightTakeOffAirport)
        preparedStatement.setDate(6, flight.flightTakeOffDate?.let { java.sql.Date.valueOf(it) })
        preparedStatement.setTime(7, flight.flightTakeOffTime?.let { java.sql.Time.valueOf(it) })
        preparedStatement.setString(8, flight.flightLandingAirport)
        preparedStatement.setDate(9, flight.flightLandingDate?.let { java.sql.Date.valueOf(it) })
        preparedStatement.setTime(10, flight.flightLandingTime?.let { java.sql.Time.valueOf(it) })

        val rowsInserted = preparedStatement.executeUpdate()
        if (rowsInserted > 0) {
            println("A new flight was inserted successfully!")
        }
        preparedStatement.close()
        connection.close()
    } catch (e: SQLException) {
        e.printStackTrace()
    }
}