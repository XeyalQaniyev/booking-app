package org.example.app.controller;

import org.example.app.constant.LoginRegister;
import org.example.app.constant.Menu;
import org.example.app.constant.SearchAndBook;
import org.example.app.entity.Reservation;
import org.example.app.entity.User;

import java.util.Arrays;

import static org.example.app.util.MenuUtil.*;

public class DispatcherController {


        private final FlightController flightController = new FlightControllerImpl();
        private final UserController userController = new UserControllerImpl();
        private final ReservationController reservationController = new ReservationControllerImpl();

        public void loginRegister(){
            showLoginAndRegisterMenu();
            int index = getIndex();
            switch (index){
                case 1->{
                    System.out.print("Enter username: ");
                    String userName = getInput();
                    System.out.print("Enter password: ");
                    String password = getInput();
                    User user = userController.authenticate(userName,password);
                    if (user != null){
                        selectMenu(user);
                    }else {
                        loginRegister();
                    }
                }
            }
        }

        public  void selectMenu(User user){
            Reservation reservation;
            boolean flag=true;
            while (flag){
                showMenu();
                int index = getIndex();
                switch (index){
                    case 1->{
                        flightController.showAll();
                        selectMenu(user);
                    }
                    case 2->{
                        System.out.println("Enter flight id:");
                        int flightId = getIndex();
                        System.out.println(flightController.getFlightById(flightId));
                        selectMenu(user);
                    }
                    case 3->{
                        showSearchAndBookMenu();
                        int menuInp = getIndex();
                        switch (menuInp){
                            case 1->{
                                flightController.searchFlight();
                            }
                            case 2->{

                            }
                        }
                    }
                    case 4->{
                        reservationController.cancelFlight(null);
                    }
                    case 5->{
                        userController.showMyFlights((int) user.getId());
                    }
                    case 6->flag=false;
                    default -> System.out.println("ENTER VALID COMMAND");
                }
            }
        }
        private void showMenu() {
            Arrays.stream(Menu.values())
                    .forEach(it -> System.out.printf("%d-%s\n", it.getIndex(), it.getDescription()));
        }
        private void showSearchAndBookMenu() {
            Arrays.stream(SearchAndBook.values())
                    .forEach(it -> System.out.printf("%d-%s\n", it.getIndex(), it.getDescription()));
        }
        private void showLoginAndRegisterMenu(){
            Arrays.stream(LoginRegister.values())
                    .forEach(it -> System.out.printf("%d-%s\n", it.getIndex(), it.getDescription()));
        }
    }
