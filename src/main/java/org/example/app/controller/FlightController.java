package org.example.app.controller;

import org.example.app.entity.Flight;

import java.util.List;

public interface FlightController {
    void showAll();
    boolean addFlight(Flight flight);
    Flight getFlightById(int flightID);
    List<Flight> getAll();
    void searchFlight();
}