package org.example.app;

import org.example.app.dao.*;
import org.example.app.entity.Flight;
import org.example.app.entity.Reservation;
import org.example.app.entity.User;
import org.example.app.util.MenuUtil;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        MenuUtil.logging("name", "sdsa");
//        System.out.println(MenuUtil.loggedUserId);
        //passed loggin

        //Online board
        FlightDao flightDao = new FlightDaoImpl();
//        flightDao.showAll();

        //SHOW THE FLIGHT INFO
//        System.out.println(flightDao.getFlightById(3));

//        //search and book
//        flightDao.searchFlight("British", LocalDate.ofEpochDay(2025-8-26),5);
//
        ReservationDao reservationDao = new ReservationDaoImpl();
        UserDao user = new UserDaoImpl();
        User client = user.getUserById(2);

        Flight flight = flightDao.getFlightById(4);
//
        Reservation res = new Reservation(client,flight,15);
//        reservationDao.bookFlight(res);
//
//        //cancel
        reservationDao.cancelFlight(res);


    }
}