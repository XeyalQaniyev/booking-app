package org.example.app.service;

import org.example.app.entity.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {
    boolean addFlight(Flight flight);

    List<Flight> getAllFlights();

    Flight getFlightById(int flightID);

    List<Flight> searchFlight(String destination, LocalDate date, int minSeats);
}
