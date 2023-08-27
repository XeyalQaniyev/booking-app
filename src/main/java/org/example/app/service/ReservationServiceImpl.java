package org.example.app.service;

import org.example.app.dao.ReservationDao;
import org.example.app.dao.ReservationImpl;
import org.example.app.entity.Flight;
import org.example.app.entity.User;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    private final ReservationDao userFlightDao = new ReservationImpl();

    @Override
    public List<Flight> getAllFlightsByUserID(User userId) {
        return userFlightDao.getAllFlightsByUserID(userId);
    }

}
