package org.example.app.dao;
import org.example.app.entity.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightDao{
    void showAll();
    boolean addFlight(Flight flight);
    Flight getFlightById(int flightID);
    List<Flight> getAll();

    List<Flight> searchFlight(String destination, LocalDate date, int minSeats);

}
