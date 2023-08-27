package org.example.app.dao;

import org.example.app.entity.Flight;
import org.example.app.entity.User;

import java.util.List;

public interface ReservationDao{
    List<Flight> getAllFlightsByUserID(User userId);
}
