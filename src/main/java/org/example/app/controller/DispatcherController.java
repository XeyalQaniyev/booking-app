package org.example.app.controller;

import org.example.app.constant.LoginRegister;
import org.example.app.constant.Menu;
import org.example.app.constant.SearchAndBook;
import org.example.app.entity.User;

import java.util.Arrays;

import static org.example.app.util.MenuUtil.getIndex;

    public class DispatcherController {

        private final FlightController flightController = new FlightControllerImpl();
        private final UserController userController = new UserControllerImpl();
        private final ReservationController reservationController = new ReservationControllerImpl();

        public void loginRegister(){
            showLoginAndRegisterMenu();
            int index = getIndex();
            switch (index){
                case 1->{

                }
            }
        }

        public  void selectMenu(){
            boolean flag=true;
            while (flag){
                showMenu();
                int index = getIndex();
                switch (index){
                    case 1->{
                        flightController.showAll();
                        selectMenu();
                    }
                    case 2->{
                        System.out.println("Enter flight id:");
                        int flightId = getIndex();
                        System.out.println(flightController.getFlightById(flightId));
                        selectMenu();
                    }
                    case 3->{
                        showSearchAndBookMenu();
                        int menuinp = getIndex();
                        switch (menuinp){
                            case 1->{
                                flightController.searchFlight();
                            }
                            case 2->{
                                reservationController.bookFlight(null);
                            }
                        }
                    }
                    case 4->{
                        reservationController.cancelFlight(null);
                    }
                    case 5->{
                        userController.showMyFlights();
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
