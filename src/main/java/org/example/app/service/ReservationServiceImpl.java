package org.example.app.service;

import org.example.app.dao.ReservationDao;
import org.example.app.dao.ReservationDaoImpl;
import org.example.app.entity.Flight;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    private final ReservationDao userFlightDao = new ReservationDaoImpl();

    @Override
    public List<Flight> getAllFlightsByUserId(int userId) {

        return userFlightDao.getAllFlightsByUserId(userId);
    }

    @Override
    public boolean cancelFlight(int userId, int flightId) {
        return userFlightDao.cancelFlight(userId,flightId);
    }

    @Override
    public boolean bookFlight(int userId, int flightId) {
        return userFlightDao.bookFlight(userId,flightId);
    }

}
