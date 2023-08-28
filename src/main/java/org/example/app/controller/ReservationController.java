package org.example.app.controller;


import org.example.app.entity.Flight;

import java.util.List;

public interface ReservationController {
    List<Flight> getAllFlights();
    boolean cancelFlight(int flightId);
    boolean bookFlight(int flightId);

}
