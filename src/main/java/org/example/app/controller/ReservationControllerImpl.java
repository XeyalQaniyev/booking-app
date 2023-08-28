
package org.example.app.controller;

import org.example.app.dao.FlightDao;
import org.example.app.dao.FlightDaoImpl;
import org.example.app.dao.UserDao;
import org.example.app.dao.UserDaoImpl;
import org.example.app.entity.Flight;
import org.example.app.entity.Reservation;
import org.example.app.entity.User;
import org.example.app.service.ReservationService;
import org.example.app.service.ReservationServiceImpl;
import org.example.app.util.MenuUtil;

import java.util.List;

public class ReservationControllerImpl implements ReservationController {
    private final ReservationService userFlightService = new ReservationServiceImpl();
    private final int userId = MenuUtil.loggedUserId;

    @Override
    public List<Flight> getAllFlights() {
        return userFlightService.getAllFlightsByUserId(userId);

    }

    @Override
    public boolean cancelFlight(Reservation reservation) {
        return userFlightService.cancelFlight(reservation);
    }

    @Override
    public boolean bookFlight(Reservation reservation) {
        if (reservation.getFlightId().getSeats() >= reservation.getPassenger()) {
            return userFlightService.bookFlight(reservation);
        } else {
            throw new ArrayIndexOutOfBoundsException("There is no enough ticket to buy");
        }
    }
}
