package org.example.app.dao;
import org.example.app.entity.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightDao{
    void showAll();
    boolean addFlight(Flight flight);
    void searchFlight();
    List<Flight> getAll();
    Flight getFlightById(int flightID);
}
