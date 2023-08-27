package org.example.app.service;

import org.example.app.dao.FlightDao;
import org.example.app.dao.FlightDaoImpl;

public class FlightServiceImpl implements  FlightService{
    private final FlightDao flightDao = new FlightDaoImpl();
}
