import java.time.LocalDate
import java.time.LocalTime

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
)