package org.example.app;

import org.example.app.controller.DispatcherController;
import org.example.app.dao.UserDao;
import org.example.app.dao.UserDaoImpl;
import org.example.app.entity.User;
import org.example.app.service.UserService;
import org.example.app.service.UserServiceImpl;

public class Main {
    private static final DispatcherController dispatcherController = new DispatcherController();

    public static void main(String[] args) {
//        Util.uploadFlight("C:\\Users\\user\\IdeaProjects\\booking-app\\doc\\FlightList.json");
        run();

    }
    private static void run() {
        System.out.println("WELCOME TO APPLICATION");

        dispatcherController.loginRegister();

        System.out.println("APPLICATION SHUT DOWN");

    }

}