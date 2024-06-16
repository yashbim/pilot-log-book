CREATE DATABASE IF NOT EXISTS pilot_log_book;
USE pilot_log_book;

CREATE TABLE IF NOT EXISTS flights(
        uuid VARCHAR(15),
flightMake VARCHAR(30),
flightModel VARCHAR(30),
flightReg VARCHAR(30),
flightTakeOffAirport VARCHAR(10),
flightTakeOffDate DATE,
flightTakeOffTime TIME,
flightLandingAirport VARCHAR(10),
flightLandingDate DATE,
flightLandingTime TIME
);
