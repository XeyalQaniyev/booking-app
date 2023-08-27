package org.example.app.dao;

import org.example.app.entity.Flight;
import org.example.app.entity.User;

import java.util.List;

public class ReservationImpl extends AbstractDao implements ReservationDao {
    @Override
    public List<Flight> getAllFlightsByUserID(int userId) {

        return null;
    }

    @Override
    public boolean cancelFlight(int flightID) {
        return false;
    }

    @Override
    public boolean bookFlight(int flightID) {

        return false;
    }
}