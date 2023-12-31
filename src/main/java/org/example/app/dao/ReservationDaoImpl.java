package org.example.app.dao;

import org.example.app.constant.Sql;
import org.example.app.entity.Flight;
import org.example.app.entity.Reservation;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationDaoImpl extends AbstractDao implements ReservationDao {
    private Flight getFlight(ResultSet rs) {
        try {
            long id = rs.getInt("id");
            int seats = rs.getInt("seats");
            String number = rs.getString("number");
            String airline = rs.getString("airline");
            String destination = rs.getString("destination");
            String depCity = rs.getString("departure_city");

            Timestamp depts = rs.getTimestamp("departure_time");
            LocalDateTime depTime = depts.toLocalDateTime();

            Timestamp arrts = rs.getTimestamp("arrival_time");
            LocalDateTime arrTime = arrts.toLocalDateTime();

            String gate = rs.getString("gate");
            String terminal = rs.getString("terminal");
            String status = rs.getString("status");
            String counter = rs.getString("counter");

            Timestamp brdts = rs.getTimestamp("boarding_time");
            LocalDateTime brdTime = brdts.toLocalDateTime();

            return new Flight(id, seats, number, airline, destination, depCity, depTime,
                    arrTime, gate, terminal, status, counter, brdTime);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void showUserFlights(int userId) {
        List<Flight> userFlights = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement(Sql.GET_ALL_FLIGHT_BY_USER_ID.getValue());

            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Flight flight = getFlight(rs);
                userFlights.add(flight);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (!userFlights.isEmpty()) {
            System.out.println("Your flights:");
            userFlights.stream().forEach(System.out::println);
        } else {
            System.err.println("You have no booked flights");
        }
    }

    @Override
    public boolean cancelFlight(Reservation reservation) {
        int userId = (int) reservation.getUserId().getId();
        int flightId = (int) reservation.getFlightId().getId();
        int ticketNum = getPassengers(flightId, userId);
        if (ticketNum == 0) {
            System.err.println("No available reservation!");
            return false;
        }
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement(Sql.CANCEL_FLIGHT.getValue());

            stmt.setInt(1, flightId);
            stmt.setInt(2, userId);
            stmt.execute();
            System.out.println("Reservation was cancelled!");
            return updateSeat(flightId, ticketNum, true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean bookFlight(Reservation reservation) {
        int userId = (int) reservation.getUserId().getId();
        int flightId = (int) reservation.getFlightId().getId();
        int ticketNum = reservation.getPassenger();
        if (ticketNum > getSeats(flightId)) {
            throw new RuntimeException("No enough tickets to buy!");
        }

        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement(Sql.BOOKING_FLIGHT.getValue());

            stmt.setInt(1, userId);
            stmt.setInt(2, flightId);
            stmt.setInt(3, ticketNum);
            stmt.execute();
            System.out.printf("%s.flight is reserved by %s.user", flightId, userId);
            return updateSeat(flightId, ticketNum, false);

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private int getPassengers(int flightId, int userId) {
        int tNum = 0;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement(Sql.GET_PASSENGER.getValue());
            stmt.setInt(1, flightId);
            stmt.setInt(2, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                tNum = rs.getInt("passenger");
            }
            return tNum;
        } catch (SQLException ex) {
            return 0;
        }
    }

    private Integer getSeats(int flightId) {
        try (Connection c = connect()) {
            Integer sNum = null;
            PreparedStatement stmt = c.prepareStatement(Sql.GET_SEAT.getValue());
            stmt.setInt(1, flightId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                sNum = rs.getInt("seats");
            }
            return sNum;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }


    private boolean updateSeat(int flightId, int ticketNum, boolean booked) {
        try (Connection c = connect()) {
            PreparedStatement stmt;
            if (booked) {
                stmt = c.prepareStatement(Sql.UPDATE_SEAT.getValue());
            } else {
                stmt = c.prepareStatement(Sql.UPDATE_SEAT_MINUS.getValue());
            }
            stmt.setInt(1, ticketNum);
            stmt.setInt(2, flightId);

            return stmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }


}