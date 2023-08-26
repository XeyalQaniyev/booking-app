package org.example.service;

import org.example.dao.UserFlightDao;
import org.example.dao.UserFlightImpl;
import org.example.entity.Flight;
import org.example.entity.User;

import java.util.List;

public interface UserFlightService {
    List<Flight> getAllFlightsByUserID(User userId);
}
