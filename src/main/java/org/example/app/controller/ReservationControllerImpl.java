
package org.example.app.controller;
import org.example.app.entity.Reservation;
import org.example.app.service.ReservationService;
import org.example.app.service.ReservationServiceImpl;


public class ReservationControllerImpl implements ReservationController {
    private final ReservationService userFlightService = new ReservationServiceImpl();

    @Override
    public void showAllFlights(int userId) {
        userFlightService.showUserFlights(userId);
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
            System.err.println("Flight is full currently");
            return false;
        }
    }
}
