
package org.example.app.controller;
import org.example.app.entity.Flight;
import org.example.app.service.ReservationService;
import org.example.app.service.ReservationServiceImpl;
import org.example.app.util.MenuUtil;

import java.util.List;

public class ReservationControllerImpl implements ReservationController {
    private final ReservationService userFlightService = new ReservationServiceImpl();
    private final int userID = MenuUtil.loggedUserID;

    @Override
    public List<Flight> getAllFlights() {

        return userFlightService.getAllFlightsByUserID(userID);

    }
}
