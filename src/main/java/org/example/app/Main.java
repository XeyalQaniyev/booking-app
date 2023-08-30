package org.example.app;

import org.example.app.controller.DispatcherController;
import org.example.app.util.Util;

public class Main {
    private static final DispatcherController dispatcherController = new DispatcherController();

    public static void main(String[] args) {
        Util.uploadFlight("");
        run();
    }

    private static void run() {
        System.out.println("WELCOME TO APPLICATION");

        dispatcherController.loginRegister();

        System.out.println("GOOD BYE");
    }

}