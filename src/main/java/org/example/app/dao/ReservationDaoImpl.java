package org.example.app.dao;

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
    public List<Flight> getAllFlightsByUserId(int userId) {
        List<Flight> flightList = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select u.id,f.* from \"Reservation\" r\n" +
                    "left join \"User\" u on r.user_id = u.id\n" +
                    "left join \"Flight\" f on r.flight_id = f.id\n" +
                    "having u.id = ?");

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
    public boolean cancelFlight(Reservation reservation) {
        int userId = (int) reservation.getUserId().getId();
        int flightId = (int) reservation.getFlightId().getId();
        int ticketNum = reservation.getPassenger();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("delete from \"Reservation\" where flight_id = ? and user_id =?");

            stmt.setInt(1, userId);
            stmt.setInt(2,  flightId);

            stmt.execute();
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
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into \"Reservation\" (user_id, flight_id) VALUES (?,?)");

            stmt.setInt(1, userId);
            stmt.setInt(2, flightId);
            stmt.execute();
            return updateSeat(flightId,ticketNum,true);

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    private boolean updateSeat(int flightId, int ticketNum, boolean booked){
        try (Connection c = connect()) {
            PreparedStatement stmt = null;
            if(booked){
            stmt = c.prepareStatement("update \"Flight\" set seats = seats + ? where id = ?");
            }
            else{
                stmt = c.prepareStatement("update \"Flight\" set seats = seats - ? where id = ?");
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