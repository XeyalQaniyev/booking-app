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
        return false;
    }

    @Override
    public Flight getFlightById(int flightID) {
        try (Connection c = connect()) {
            Flight flight = null;
            PreparedStatement stmt = c.prepareStatement("select * from \"Flight\" where id = ?");
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
            PreparedStatement stmt = c.prepareStatement("select * from \"Flight\" ");
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
                        (s.getDepartureTime().getYear() == date.getYear() && s.getDepartureTime().getMonth() == date.getMonth() &&
                                s.getDepartureTime().getDayOfMonth() == date.getDayOfMonth()))
                        && s.getSeats() >= minSeats && s.getSeats() > 0))
                .forEach(System.out::println);

    }

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


}
