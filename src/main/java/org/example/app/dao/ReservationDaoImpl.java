package org.example.app.dao;

import org.example.app.entity.Flight;
import org.example.app.entity.Reservation;
import org.example.app.entity.User;
import org.postgresql.util.PSQLException;

import javax.xml.transform.Result;
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

        if(ticketNum != getPassengers(flightId,userId)){
            throw new RuntimeException("Number of passengers must be equal as you booked!");
        }

        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("delete from \"Reservation\" where flight_id = ? and user_id =?");

            stmt.setInt(1, flightId);
            stmt.setInt(2,  userId);

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

        if(ticketNum > getSeats(flightId)){
            throw new RuntimeException("No enough tickets to buy!");
        }

        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into \"Reservation\" (user_id, flight_id, passenger) VALUES (?,?,?)");

            stmt.setInt(1, userId);
            stmt.setInt(2, flightId);
            stmt.setInt(3, ticketNum);
            stmt.execute();
            System.out.printf("%s.flight is reserved by %s.user",flightId,userId);
            return updateSeat(flightId,ticketNum,false);

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private Integer getPassengers(int flightId, int userId) {

        try (Connection c = connect()) {
            Integer tNum = null;
            PreparedStatement stmt = c.prepareStatement("select * from \"Reservation\" where flight_id = ? and user_id =?");
            stmt.setInt(1, flightId);
            stmt.setInt(2, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                tNum = rs.getInt("passenger");
            }
            return tNum;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    private Integer getSeats(int flightId){
        try (Connection c = connect()) {
            Integer sNum = null;
            PreparedStatement stmt = c.prepareStatement("select seats from \"Flight\" where id = ?");
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