package org.example.dao;

import org.example.entity.Flight;

import java.util.List;

public interface FlightDao{
    void showAll();
    boolean addFlight(Flight flight);
    Flight getFlightById(int flightID);
    List<Flight> getAll();





}
