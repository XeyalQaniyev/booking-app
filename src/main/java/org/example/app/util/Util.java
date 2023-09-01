package org.example.app.util;

import org.example.app.controller.FlightController;
import org.example.app.controller.FlightControllerImpl;
import org.example.app.entity.Flight;
import org.example.app.entity.Reservation;
import org.example.app.entity.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Util {
    public static String parseString(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return localDate.format(formatter);
    }

    public static LocalDate parseLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(date, formatter);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private static List<Flight> writeFileIntoList(String filePath) {
        JSONParser jsonParser = new JSONParser();
        List<Flight> fRecord = new ArrayList<>();
        try (FileReader reader = new FileReader(filePath)) {
            Object obj = jsonParser.parse(reader);
            JSONArray list = (JSONArray) obj;
            for (Object listObj : list) {
                fRecord.add(getFlight(listObj));
            }
            return fRecord;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static Flight getFlight(Object listObj) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        JSONObject obj4 = (JSONObject) listObj;
        long seats = (long) obj4.get("seats");
        String flightNumber = (String) obj4.get("flightNumber");
        String airline = (String) obj4.get("airline");
        String destination = (String) obj4.get("destination");
        String departureCity = (String) obj4.get("departureCity");
        LocalDateTime departureTime = LocalDateTime.parse((String) obj4.get("departureTime"), formatter);
        LocalDateTime arrivalTime = LocalDateTime.parse((String) obj4.get("arrivalTime"), formatter);
        String gate = (String) obj4.get("gate");
        String terminal = (String) obj4.get("terminal");
        String status = (String) obj4.get("status");
        String checkInCounter = (String) obj4.get("checkInCounter");
        LocalDateTime boardingTime = LocalDateTime.parse((String) obj4.get("boardingTime"), formatter);
        return new Flight((int) seats, flightNumber, airline, destination, departureCity, departureTime
                , arrivalTime, gate, terminal, status, checkInCounter, boardingTime);
    }

    public static boolean uploadFlight(String filePath) {
        List<Flight> flightList = writeFileIntoList(filePath);
        FlightController flightController = new FlightControllerImpl();
        try {
            assert flightList != null;
            flightList.forEach(flightController::addFlight);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static User createUser(){
        System.out.print("Enter name: ");
        String name = MenuUtil.getInput();
        System.out.print("Enter surname: ");
        String surname = MenuUtil.getInput();
        System.out.print("Enter age: ");
        int age = MenuUtil.getIndex();
        System.out.print("Enter username: ");
        String username = MenuUtil.getInput();
        System.out.print("Enter password: ");
        String password = MenuUtil.getInput();
        return new User(name,surname,age,username,password);
    }
    public static User createPassenger(){
        System.out.print("Enter name: ");
        String name = MenuUtil.getInput();
        System.out.print("Enter surname: ");
        String surname = MenuUtil.getInput();
        System.out.print("Enter age: ");
        int age = MenuUtil.getIndex();
        return new User(name,surname,age);
    }
    public static Reservation createRez1(User user){
        FlightController flightController = new FlightControllerImpl();
        System.out.println("Enter flight id: ");
        int flightId = MenuUtil.getIndex();
        return new Reservation(user,flightController.getFlightById(flightId));
    }
}