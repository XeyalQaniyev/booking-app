package org.example.app.dao;

import org.example.app.entity.Flight;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FlightDaoImpl extends AbstractDao implements FlightDao {
    static Predicate<Flight> c1 = c -> c.getSeats() > 0;

    @Override
    public void showAll() {
        getAll().stream().filter(c1).forEach(System.out::println);
    }

    @Override
    public boolean addFlight(Flight flight) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement(
                    "INSERT INTO \"Flight\" (seats, number, airline, destination, departure_city, " +
                            "departure_time, arrival_time, gate, terminal, status, counter, boarding_time) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, flight.getSeats());
            stmt.setString(2, flight.getFlightNumber());
            stmt.setString(3, flight.getAirline());
            stmt.setString(4, flight.getDestination());
            stmt.setString(5, flight.getDepartureCity());
            stmt.setTimestamp(6, Timestamp.valueOf(flight.getDepartureTime()));
            stmt.setTimestamp(7, Timestamp.valueOf(flight.getArrivalTime()));
            stmt.setString(8, flight.getGate());
            stmt.setString(9, flight.getTerminal());
            stmt.setString(10, flight.getStatus());
            stmt.setString(11, flight.getCheckInCounter());
            stmt.setTimestamp(12, Timestamp.valueOf(flight.getBoardingTime()));

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Flight getFlightById(int flightID) {
        try (Connection c = connect()) {
            Flight flight = null;
            PreparedStatement stmt = c.prepareStatement("SELECT * FROM \"Flight\" WHERE id = ?");
            stmt.setInt(1, flightID);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                flight = getFlight(rs);
            }
            return flight;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Flight> getAll() {
        List<Flight> flightList = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("SELECT * FROM \"Flight\"");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                Flight f = getFlight(rs);
                flightList.add(f);
            }
            return flightList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void searchFlight(String destination, LocalDate date, int minSeats) {
        getAll().stream()
                .filter(s -> ((s.getDestination().contains(destination) ||
                        (s.getDepartureTime().toLocalDate().equals(date))
                                && s.getSeats() >= minSeats && s.getSeats() > 0)))
                .forEach(System.out::println);

    }

    private Flight getFlight(ResultSet rs) {
        try {
            long id = rs.getLong("id");
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
}
