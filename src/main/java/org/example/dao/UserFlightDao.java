package org.example.dao;

import org.example.entity.Flight;
import org.example.entity.User;

import java.util.List;

public interface UserFlightDao {
  List<Flight> getAllFlightsByUserID(User userId);
}
