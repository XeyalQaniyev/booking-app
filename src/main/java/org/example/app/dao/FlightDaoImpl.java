package org.example.app.dao;


import org.example.app.entity.Flight;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class FlightDaoImpl extends AbstractDao implements FlightDao {
    static Predicate<Flight> c1 = c -> c.getSeats() > 0;
    @Override
    public void showAll() {
            getAll().stream().filter(c1).forEach(System.out::println);
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
