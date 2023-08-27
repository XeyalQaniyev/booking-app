package org.example.app.controller;

import org.example.app.entity.Flight;
import org.example.app.entity.User;

import java.util.List;

public interface ReservationController {
    List<Flight> getAllFlightsByUserID(User userId);
}
