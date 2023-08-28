package org.example.app.service;

import org.example.app.entity.Flight;
import org.example.app.entity.Reservation;

import java.util.List;

public interface ReservationService {

    List<Flight> getAllFlightsByUserId(int userId);
    boolean cancelFlight(Reservation reservation);
    boolean bookFlight(Reservation reservation);

}
