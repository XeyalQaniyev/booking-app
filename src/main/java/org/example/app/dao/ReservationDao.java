package org.example.app.dao;

import org.example.app.entity.Flight;
import org.example.app.entity.Reservation;

import java.util.List;

public interface ReservationDao{
  List<Flight> getAllFlightsByUserId(int userId);
  boolean cancelFlight(Reservation reservation);
  boolean bookFlight(Reservation reservation);

}
