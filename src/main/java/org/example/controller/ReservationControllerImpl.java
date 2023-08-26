package org.example.controller;
import org.example.entity.Flight;
import org.example.entity.User;
import org.example.service.ReservationService;
import org.example.service.ReservationServiceImpl;

import java.util.List;

public class ReservationControllerImpl implements ReservationController {
    private final ReservationService userFlightService = new ReservationServiceImpl();

    @Override
    public List<Flight> getAllFlightsByUserID(User userId) {

        return userFlightService.getAllFlightsByUserID(userId);

    }
}
