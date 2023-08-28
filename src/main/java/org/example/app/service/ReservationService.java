package org.example.app.service;

import org.example.app.entity.Flight;

import java.util.List;

public interface ReservationService {

    List<Flight> getAllFlightsByUserId(int userId);
    boolean cancelFlight(int userId, int flightId);
    boolean bookFlight(int userId, int flightId);

}
