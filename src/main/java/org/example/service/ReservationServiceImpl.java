package org.example.service;

import org.example.dao.ReservationDao;
import org.example.dao.ReservationImpl;
import org.example.entity.Flight;
import org.example.entity.User;
import org.example.util.MenuUtil;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    private final ReservationDao userFlightDao = new ReservationImpl();

    @Override
    public List<Flight> getAllFlightsByUserID(int userID) {

        return userFlightDao.getAllFlightsByUserID(userID);
    }

}
