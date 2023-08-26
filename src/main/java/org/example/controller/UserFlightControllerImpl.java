package org.example.controller;

import org.example.entity.Flight;
import org.example.entity.User;
import org.example.service.UserFlightService;
import org.example.service.UserFlightServiceImpl;

import java.util.List;

public class UserFlightControllerImpl implements UserFlightController {
    private final UserFlightService userFlightService = new UserFlightServiceImpl();

    @Override
    public List<Flight> getAllFlightsByUserID(User userId) {

        return userFlightService.getAllFlightsByUserID(userId);
    }
}
