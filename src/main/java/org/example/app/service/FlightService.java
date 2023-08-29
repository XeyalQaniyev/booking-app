package org.example.app.service;

import org.example.app.entity.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {
    void showAll();
    boolean addFlight(Flight flight);
    Flight getFlightById(int flightID);
    List<Flight> getAll();
    void searchFlight(String destination, LocalDate date, int minSeats);
}
