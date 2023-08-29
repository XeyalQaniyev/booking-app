package org.example.app.controller;

import org.example.app.entity.Flight;
import org.example.app.service.FlightService;
import org.example.app.service.FlightServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class FlightControllerImpl implements FlightController {
    private final FlightService flightService = new FlightServiceImpl();

    @Override
    public void showAll() {
        flightService.showAll();
    }

    @Override
    public boolean addFlight(Flight flight) {
        return flightService.addFlight(flight);
    }

    @Override
    public Flight getFlightById(int flightID) {
        return flightService.getFlightById(flightID);
    }

    @Override
    public List<Flight> getAll() {
        return flightService.getAll();
    }

    @Override
    public void searchFlight() {
        flightService.searchFlight();

    }
}
