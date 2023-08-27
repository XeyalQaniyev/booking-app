package org.example.app.controller;
import org.example.app.entity.Flight;
import org.example.app.entity.User;
import org.example.app.service.ReservationService;
import org.example.app.service.ReservationServiceImpl;

import java.util.List;

public class ReservationControllerImpl implements ReservationController {
    private final ReservationService userFlightService = new ReservationServiceImpl();

    @Override
    public List<Flight> getAllFlightsByUserID(User userId) {

        return userFlightService.getAllFlightsByUserID(userId);

    }
}