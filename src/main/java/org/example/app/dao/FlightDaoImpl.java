package org.example.app.dao;

import org.example.app.entity.Flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import java.util.function.Predicate;


public class FlightDaoImpl extends AbstractDao implements FlightDao {
    static Predicate<Flight> c1 = c -> c.getSeats() > 0;
    @Override
    public void showAll() {
            getAll().stream().filter(c1).forEach(System.out::println);
    }

    @Override
    public Flight getFlightById(int flightID) {
            return getAll().get(flightID);
    }

    @Override
    public boolean addFlight(Flight flight) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("INSERT INTO Flight(seats, flightNumber, airline, destination, departure_city, departure_time, arrival_time, gate, terminal, status, counter, boarding_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, flight.getSeats());
            stmt.setString(2, flight.getFlightNumber());
            stmt.setString(3, flight.getAirline());
            stmt.setString(4, flight.getDestination());
            stmt.setString(5, flight.getDepartureCity());
            stmt.setObject(6, flight.getDepartureTime());
            stmt.setObject(7, flight.getArrivalTime());
            stmt.setString(8, flight.getGate());
            stmt.setString(9, flight.getTerminal());
            stmt.setString(10, flight.getStatus());
            stmt.setString(11, flight.getCheckInCounter());
            stmt.setObject(12, flight.getBoardingTime());

            return stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
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

    private Flight extractFlightFromResultSet(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        int seats = rs.getInt("seats");
        String flightNumber = rs.getString("flightNumber");
        String airline = rs.getString("airline");
        String destination = rs.getString("destination");
        String departureCity = rs.getString("departureCity");
        LocalDateTime departureTime = rs.getObject("departureTime", LocalDateTime.class);
        LocalDateTime arrivalTime = rs.getObject("arrivalTime", LocalDateTime.class);
        String gate = rs.getString("gate");
        String terminal = rs.getString("terminal");
        String status = rs.getString("status");
        String checkInCounter = rs.getString("checkInCounter");
        LocalDateTime boardingTime = rs.getObject("boardingTime", LocalDateTime.class);

        return new Flight(id, seats, flightNumber, airline, destination, departureCity,
                departureTime, arrivalTime, gate, terminal, status, checkInCounter, boardingTime);
    }

    @Override
    public List<Flight> searchFlight(String destination, LocalDate date, int minSeats) {
        return getAll().stream()
                .filter(s -> (s.getDestination().equals(destination) ||
                        (s.getDepartureTime().getYear() == date.getYear()
                                && s.getDepartureTime().getMonth() == date.getMonth())
                                && s.getSeats() >= minSeats))
                .collect(Collectors.toList());
    }

}
