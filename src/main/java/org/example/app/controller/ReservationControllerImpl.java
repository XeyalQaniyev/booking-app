
package org.example.app.controller;
import org.example.app.entity.Flight;
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
    public boolean cancelFlight(int flightId) {
        return userFlightService.cancelFlight(userId,flightId);
    }

    @Override
    public boolean bookFlight(int flightId) {
        return userFlightService.bookFlight(userId,flightId);
    }
}
