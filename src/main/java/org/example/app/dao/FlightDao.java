package org.example.app.dao;
import org.example.app.entity.Flight;

import java.util.List;

public interface FlightDao{
    void showAll();
    boolean addFlight(Flight flight);
    Flight getFlightById(int flightID);
    List<Flight> getAllFlight();
    void searchFlight();





}
