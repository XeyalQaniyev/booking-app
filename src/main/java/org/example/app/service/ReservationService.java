package org.example.service;

import org.example.entity.Flight;
import org.example.entity.User;
import org.example.util.MenuUtil;

import java.util.List;

public interface ReservationService {

    List<Flight> getAllFlightsByUserID(int userID);

}
