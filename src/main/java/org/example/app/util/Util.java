package org.example.app.util;

import org.example.app.entity.Flight;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<Flight> writeFileIntoList(String filePath) {

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
        return new Flight(flightNumber, airline, destination, departureCity, departureTime
                , arrivalTime, gate, terminal, status, checkInCounter, boardingTime);

    }


}
