package org.example.controller;

import org.example.service.FlightService;
import org.example.service.FlightServiceImpl;

public class FlightControllerImpl implements FlightController {
    private final FlightService flightService = new FlightServiceImpl();
}
