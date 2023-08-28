package org.example.app.service;

import org.example.app.dao.FlightDao;
import org.example.app.dao.FlightDaoImpl;
import org.example.app.entity.Flight;

import java.time.LocalDate;
import java.util.List;

public class FlightServiceImpl implements FlightService {
    private final FlightDao flightDao = new FlightDaoImpl();

    @Override
    public boolean addFlight(Flight flight) {
        return flightDao.addFlight(flight);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightDao.getAll();
    }

    @Override
    public Flight getFlightById(int flightID) {
        return flightDao.getFlightById(flightID);
    }

    @Override
    public void searchFlight(String destination, LocalDate date, int minSeats) {
        flightDao.searchFlight(destination, date, minSeats);
    }
}
