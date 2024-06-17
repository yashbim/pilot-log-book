import java.sql.SQLException

fun deleteFlight(flights: MutableList<Flight>){
    viewFlights(flights)
    println("Enter UID of flight needed to be deleted")
    val delInput = readln()

    val connection = getConnection()
    if (connection != null) {
        val query = "SELECT * FROM flights WHERE UUID = '$delInput'"
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
    println("Are you sure you want to delete this flight? (y/n)")
    var deleteOption = readln()

    while (true){
        if (deleteOption == "y"){
            println("Deleting Flight:")

            val connection = getConnection()
            if (connection != null) {
                val query = "DELETE FROM flights WHERE UUID = '$delInput'"
                try {
                    val statement = connection.createStatement()
                    val rowsAffected = statement.executeUpdate(query)
                    if (rowsAffected > 0) {
                        println("Flight deleted successfully.")
                        break
                    } else {
                        println("Flight not found.")
                        break
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

        } else  {
            println("Not deleted")
            break
        }
    }
}