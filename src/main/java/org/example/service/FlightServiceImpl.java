package org.example.service;

import org.example.dao.FlightDao;
import org.example.dao.FlightDaoImpl;

public class FlightServiceImpl implements  FlightService{
    private final FlightDao flightDao = new FlightDaoImpl();
}
