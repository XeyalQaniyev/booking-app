package org.example.app.entity;

import java.time.LocalDateTime;

public class Flight {
    private long id;
    private int seats;
    private String flightNumber;
    private String airline;
    private String destination;
    private String departureCity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String gate;
    private String terminal;
    private String status;
    private String checkInCounter;
    private LocalDateTime boardingTime;

    public Flight(Long id, int seats, String flightNumber, String airline, String destination, String departureCity, LocalDateTime departureTime, LocalDateTime arrivalTime, String gate, String terminal, String status, String checkInCounter, LocalDateTime boardingTime) {
        this.id = id;
        this.seats = seats;
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.destination = destination;
        this.departureCity = departureCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.gate = gate;
        this.terminal = terminal;
        this.status = status;
        this.checkInCounter = checkInCounter;
        this.boardingTime = boardingTime;
    }

    public Flight(int seats, String flightNumber, String airline, String destination, String departureCity, LocalDateTime departureTime, LocalDateTime arrivalTime, String gate, String terminal, String status, String checkInCounter, LocalDateTime boardingTime) {
        this.seats = seats;
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.destination = destination;
        this.departureCity = departureCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.gate = gate;
        this.terminal = terminal;
        this.status = status;
        this.checkInCounter = checkInCounter;
        this.boardingTime = boardingTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCheckInCounter() {
        return checkInCounter;
    }

    public void setCheckInCounter(String checkInCounter) {
        this.checkInCounter = checkInCounter;
    }

    public LocalDateTime getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(LocalDateTime boardingTime) {
        this.boardingTime = boardingTime;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "\nid=" + id + ",\n" +
                "seats=" + seats + ",\n" +
                "flightNumber='" + flightNumber + '\'' + ",\n" +
                "airline='" + airline + '\'' + ",\n" +
                "destination='" + destination + '\'' + ",\n" +
                "departureCity='" + departureCity + '\'' + ",\n" +
                "departureTime=" + departureTime + ",\n" +
                "arrivalTime=" + arrivalTime + ",\n" +
                "gate='" + gate + '\'' + ",\n" +
                "terminal='" + terminal + '\'' + ",\n" +
                "status='" + status + '\'' + ",\n" +
                "checkInCounter='" + checkInCounter + '\'' + ",\n" +
                "boardingTime=" + boardingTime + "\n" +
                "}";

    }
}
