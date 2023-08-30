package org.example.app.service;

import org.example.app.dao.ReservationDao;
import org.example.app.dao.ReservationDaoImpl;
import org.example.app.entity.Flight;
import org.example.app.entity.Reservation;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    private final ReservationDao userFlightDao = new ReservationDaoImpl();

    @Override
    public List<Flight> getAllFlightsByUserId(int userId) {

        return userFlightDao.getAllFlightsByUserId(userId);
    }

    @Override
    public boolean cancelFlight(Reservation reservation) {
        return userFlightDao.cancelFlight(reservation);
    }

    @Override
    public boolean bookFlight(Reservation reservation) {

        return userFlightDao.bookingFlight(reservation);
    }

}
