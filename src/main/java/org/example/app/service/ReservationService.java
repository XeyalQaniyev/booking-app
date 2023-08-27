package org.example.app.service;

import org.example.app.entity.Flight;
import org.example.app.entity.User;

import java.util.List;

public interface ReservationService {
    List<Flight> getAllFlightsByUserID(User userId);
}