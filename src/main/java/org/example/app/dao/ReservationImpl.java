package org.example.app.dao;

import org.example.app.entity.Flight;
import org.example.app.entity.User;

import java.util.List;

public class ReservationImpl extends AbstractDao implements ReservationDao {
    @Override
    public List<Flight> getAllFlightsByUserID(int userId) {
        return null;
    }
}