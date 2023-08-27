package org.example.controller;
import org.example.entity.Flight;
import org.example.service.ReservationService;
import org.example.service.ReservationServiceImpl;
import org.example.util.MenuUtil;

import java.util.List;

public class ReservationControllerImpl implements ReservationController {
    private final ReservationService userFlightService = new ReservationServiceImpl();
    private final int userID = MenuUtil.loggedUserID;

    @Override
    public List<Flight> getAllFlights() {

        return userFlightService.getAllFlightsByUserID(userID);

    }
}
