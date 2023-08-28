package org.example.app.dao;


import org.example.app.entity.Flight;

import java.sql.ResultSet;
import java.util.List;

public interface ReservationDao{
  List<Flight> getAllFlightsByUserId(int userId);
  boolean cancelFlight(int userId, int flightId);
  boolean bookFlight(int userId, int flightId);
}
