package org.example.app.service;

import org.example.app.entity.Flight;

import java.util.List;

public interface ReservationService {

    List<Flight> getAllFlightsByUserID(int userID);

}
