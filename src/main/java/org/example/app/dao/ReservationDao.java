package org.example.app.dao;


import org.example.app.entity.Flight;

import java.util.List;

public interface ReservationDao{
  List<Flight> getAllFlightsByUserID(int userId);
  boolean cancelFlight(int flightID);
  boolean bookFlight(int flightID);

}
