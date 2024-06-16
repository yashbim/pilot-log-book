import java.time.LocalDate
import java.time.LocalTime

data class Flight(
    val uuid: String,
    val flightMake: String,
    val flightModel: String,
    val flightReg: String,
    var flightTakeOffAirport: String,
    var flightTakeOffDate: LocalDate,
    var flightTakeOffTime: LocalTime,
    var flightLandingAirport: String,
    var flightLandingDate: LocalDate,
    var flightLandingTime: LocalTime
)
