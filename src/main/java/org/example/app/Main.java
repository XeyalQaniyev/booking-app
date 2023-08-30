package org.example.app;

import org.example.app.dao.*;
import org.example.app.entity.Flight;
import org.example.app.entity.Reservation;
import org.example.app.entity.User;
import org.example.app.util.MenuUtil;
import org.example.app.util.Util;

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
        User client = user.getUserById(8);
        Flight flight = flightDao.getFlightById(5);
        Flight flight2 = flightDao.getFlightById(9);
        Reservation res = new Reservation(client,flight,10);
        Reservation res1 = new Reservation(client,flight2,10);
//        reservationDao.showUserFlights(3);
        flightDao.searchFlight();
//
//        //cancel
//        reservationDao.cancelFlight(res);

//        System.out.println(Util.uploadFlight("C:\\Users\\user\\IdeaProjects\\booking-app\\doc\\FlightList.json"));


    }
}