package org.example.app.dao;

import org.example.app.constant.Sql;
import org.example.app.entity.Flight;
import org.example.app.util.Util;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FlightDaoImpl extends AbstractDao implements FlightDao {
    static Predicate<Flight> c1 = c -> c.getSeats() > 0;

    @Override
    public void showAll() {
        getAllFlight().stream().filter(c1).forEach(System.out::println);
    }

    @Override
    public boolean addFlight(Flight flight) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement(Sql.ADD_FLIGHT.getValue());

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
            PreparedStatement stmt = c.prepareStatement(Sql.GET_FLIGHT_BY_ID.getValue());
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
    public List<Flight> getAllFlight() {
        List<Flight> flightList = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement(Sql.GET_ALL_FLIGHT.getValue());
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
    public void searchFlight() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the destination: ");
        String destination = sc.next();
        System.out.println("Enter the departure time: ");
        System.out.println("Example: 2023-03-03");
        LocalDate date = Util.parseLocalDate(sc.next());
        System.out.println("How many tickets: ");
        int tickets = sc.nextInt();

       List<Flight> filteredFlights =  getAll().stream()
                .filter(
                        s -> (
                                (s.getDestination().contains(destination) &&
                        (s.getDepartureTime().getYear() == date.getYear() &&
                                s.getDepartureTime().getMonth() == date.getMonth() &&
                                s.getDepartureTime().getDayOfMonth() == date.getDayOfMonth())
                                )
                        && s.getSeats() >= tickets && s.getSeats() > 0)
                )
               .toList();

       if(!filteredFlights.isEmpty()){
           filteredFlights.stream().forEach(System.out::println);
       }
       else{
           System.err.println("No current fight in this criteria");
       }
    }

    private Flight getFlight(ResultSet rs) {
        try {
            long id = rs.getLong("id");
            int seats = rs.getInt("seats");
            String number = rs.getString("number");
            String airline = rs.getString("airline");
            String destination = rs.getString("destination");
            String depCity = rs.getString("departure_city");
            LocalDateTime depTime = rs.getTimestamp("departure_time").toLocalDateTime();
            LocalDateTime arrTime = rs.getTimestamp("arrival_time").toLocalDateTime();
            String gate = rs.getString("gate");
            String terminal = rs.getString("terminal");
            String status = rs.getString("status");
            String counter = rs.getString("counter");
            LocalDateTime brdTime = rs.getTimestamp("boarding_time").toLocalDateTime();

            return new Flight(id, seats, number, airline, destination, depCity, depTime, arrTime, gate, terminal,
                    status, counter, brdTime);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
