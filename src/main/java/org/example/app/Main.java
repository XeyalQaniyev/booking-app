package org.example.app;

import org.example.app.constant.FilePath;
import org.example.app.controller.DispatcherController;
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
    private static final DispatcherController dispatcherController = new DispatcherController();

    public static void main(String[] args) {
        Util.uploadFlight("C:\\Users\\Bitboxlab-1\\IdeaProjects\\booking-app\\doc\\FlightList.json");
        run();
    }

    private static void run() {
        System.out.println("WELCOME TO APPLICATION");

        dispatcherController.loginRegister();

        System.out.println("GOOD BYE");
    }

}