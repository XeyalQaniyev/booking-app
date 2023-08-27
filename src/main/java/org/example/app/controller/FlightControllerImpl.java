package org.example.app.controller;

import org.example.app.service.FlightService;
import org.example.app.service.FlightServiceImpl;

public class FlightControllerImpl implements FlightController {
    private final FlightService flightService = new FlightServiceImpl();
}