package org.example.controller;

import org.example.entity.Flight;
import org.example.entity.User;

import java.util.List;

public interface UserFlightController {
    List<Flight> getAllFlightsByUserID(User userId);
}
