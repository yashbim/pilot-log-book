import java.sql.SQLException

fun viewFlights(flight: MutableList<Flight>){
    val connection = getConnection()

    if (connection != null) {
        val query = "SELECT * FROM flights"

        try {
            val statement = connection.createStatement()
            val resultSet = statement.executeQuery(query)

            while (resultSet.next()) {
                val uuid = resultSet.getString("uuid")
                val flightMake = resultSet.getString("flightMake")
                val flightModel = resultSet.getString("flightModel")
                val flightReg = resultSet.getString("flightReg")
                val flightTakeOffAirport = resultSet.getString("flightTakeOffAirport")
                val flightTakeOffDate = resultSet.getDate("flightTakeOffDate")
                val flightTakeOffTime = resultSet.getTime("flightTakeOffTime")
                val flightLandingAirport = resultSet.getString("flightLandingAirport")
                val flightLandingDate = resultSet.getDate("flightLandingDate")
                val flightLandingTime = resultSet.getTime("flightLandingTime")

                println("UUID: $uuid, Make: $flightMake, Model: $flightModel, Reg: $flightReg, " +
                        "TakeOff Airport: $flightTakeOffAirport, TakeOff Date: $flightTakeOffDate, " +
                        "TakeOff Time: $flightTakeOffTime, Landing Airport: $flightLandingAirport, " +
                        "Landing Date: $flightLandingDate, Landing Time: $flightLandingTime")
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        } finally {
            try {
                connection.close()
            } catch (e: SQLException) {
                e.printStackTrace()
            }
        }
    }
}