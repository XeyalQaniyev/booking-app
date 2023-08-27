package org.example.dao;

import org.example.entity.Flight;
import org.example.entity.User;

import java.util.List;

public class ReservationImpl extends AbstractDao implements ReservationDao {
    @Override
    public List<Flight> getAllFlightsByUserID(User userId) {
        return null;
    }
}
