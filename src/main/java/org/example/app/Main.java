package org.example.app;

import org.example.app.controller.DispatcherController;
import org.example.app.util.MenuUtil;
import org.example.app.util.Util;

public class Main {
    private static final DispatcherController dispatcherController = new DispatcherController();

    public static void main(String[] args) {
        Util.uploadFlight("C:\\Users\\aveira\\Documents\\GitHub\\other_github_repos\\booking-app\\doc\\FlightList.json");
        run();

    }

    private static void run() {
        System.out.println("WELCOME TO APPLICATION");

        dispatcherController.loginRegister();

        System.out.println("APPLICATION SHUT DOWN");

    }

}