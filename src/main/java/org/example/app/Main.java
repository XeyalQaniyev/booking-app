package org.example.app;

import org.example.app.controller.FlightController;
import org.example.app.controller.FlightControllerImpl;
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
//        FlightDao flightDao = new FlightDaoImpl();
//        flightDao.showAll();

        //SHOW THE FLIGHT INFO
//        System.out.println(flightDao.getFlightById(3));

//        //search and book
//        flightDao.searchFlight("British", LocalDate.ofEpochDay(2025-8-26),5);
//
//        ReservationDao reservationDao = new ReservationDaoImpl();
//        UserDao user = new UserDaoImpl();
//        User client = user.getUserById(8);
//        Flight flight = flightDao.getFlightById(5);
////        System.out.println(flight.getId());
//        Reservation res = new Reservation(client,flight,10);
//        reservationDao.bookFlight(res);

//
//        //cancel
//        reservationDao.cancelFlight(res);

//        System.out.println(Util.uploadFlight("C:\\Users\\user\\IdeaProjects\\booking-app\\doc\\FlightList.json"));


        FlightController controller = new FlightControllerImpl();
        controller.searchFlight();

    }
}