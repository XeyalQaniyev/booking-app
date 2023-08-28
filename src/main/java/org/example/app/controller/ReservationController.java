package org.example.app.controller;


import org.example.app.entity.Flight;
import org.example.app.entity.Reservation;

import java.util.List;

public interface ReservationController {
    List<Flight> getAllFlights();
    boolean cancelFlight(Reservation reservation);
    boolean bookFlight(Reservation reservation);

}
