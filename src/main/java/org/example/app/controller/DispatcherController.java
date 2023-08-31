package org.example.app.controller;

import org.example.app.entity.Reservation;
import org.example.app.entity.User;
import org.example.app.util.MenuUtil;

import static org.example.app.util.MenuUtil.*;
import static org.example.app.util.Util.*;

public class DispatcherController {
    private static int logginCount = 0;
    private final FlightController flightController = new FlightControllerImpl();
    private final UserController userController = new UserControllerImpl();
    private final ReservationController reservationController = new ReservationControllerImpl();

    public void loginRegister() {
        MenuUtil.showLoginAndRegisterMenu();
        int index = getIndex();
        switch (index) {
            case 1 -> {
                logging();
            }
            case 2 -> {
                register();
            }

        }
    }

    public void selectMenu(User user) {
        Reservation reservation;
        boolean flag = true;
        while (flag) {
            MenuUtil.showMenu();
            int index = getIndex();
            switch (index) {
                case 1 -> {
                    flightController.showAll();
                    selectMenu(user);
                }
                case 2 -> {
                    System.out.println("Enter flight id:");
                    int flightId = getIndex();
                    System.out.println(flightController.getFlightById(flightId));
                    selectMenu(user);
                }
                case 3 -> {
                    MenuUtil.showSearchAndRezervMenu();
                    int menuInp = getIndex();
                    switch (menuInp) {
                        case 1 -> {
                            flightController.searchFlight();
                        }
                        case 2 -> {
                            reservation = createRez(user);
                            reservationController.bookFlight(reservation);
                        }
                    }
                }
                case 4 -> {
                    reservation = createRez1(user);
                    reservationController.cancelFlight(reservation);
                }
                case 5 -> {
                    reservationController.showAllFlights((int) user.getId());
                }
                case 6 -> {
                    loginRegister();
                }
                case 7 -> flag = false;
                default -> System.out.println("ENTER VALID COMMAND");
            }
        }
    }


    private void logging() {
        for (int attempts = logginCount; attempts < 3; attempts++) {
            logginCount++;
            System.out.print("Enter username: ");
            String userName = getInput();
            System.out.print("Enter password: ");
            String password = getInput();

            User user = userController.authenticate(userName, password);

            if (user != null) {
                selectMenu(user);
                return;
            } else if (attempts == 2) {
                throw new RuntimeException("No possible user!");
            } else {
                System.err.println("Wrong username or password!");
                loginRegister();
            }

        }
    }







    private void register() {
        User user = createUser();
        if (userController.addUser(user)) {
            selectMenu(user);
        } else {
            System.err.println("Register failed!");
            loginRegister();
        }
    }
}
