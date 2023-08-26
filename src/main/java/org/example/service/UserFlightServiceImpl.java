package org.example.service;

import org.example.dao.UserFlightDao;
import org.example.dao.UserFlightImpl;
import org.example.entity.Flight;
import org.example.entity.User;

import java.util.List;

public class UserFlightServiceImpl implements UserFlightService {
    private final UserFlightDao userFlightDao = new UserFlightImpl();

    @Override
    public List<Flight> getAllFlightsByUserID(User userId) {
        return userFlightDao.getAllFlightsByUserID(userId);
    }
}
