package org.example.app.dao;


import org.example.app.entity.Flight;

import java.time.LocalDate;
import java.util.List;

public class FlightDaoImpl extends AbstractDao implements FlightDao {

    @Override
    public void showAll() {

    }
    @Override
    public boolean addFlight(Flight flight) {
        return false;
    }

    @Override
    public Flight getFlightById(int flightID) {
        return null;
    }

    @Override
    public List<Flight> getAll() {
        return null;
    }

    @Override
    public void searchFlight(String destination, LocalDate date, int minSeats) {
        getAll().stream()
                .filter(s->(s.getDestination().equals(destination)||
                (s.getDepartureTime().getYear()==date.getYear() && s.getDepartureTime().getMonth()==date.getMonth())
                        &&s.getSeats()>=minSeats))
                .forEach(System.out::println);
    }


}
