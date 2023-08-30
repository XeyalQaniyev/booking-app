package org.example.app.dao;

import org.example.app.entity.Flight;
import org.example.app.entity.Reservation;

import java.util.List;

public interface ReservationDao{
  void showUserFlights(int userId);
  boolean cancelFlight(Reservation reservation);
  boolean bookingFlight(Reservation reservation);
}
