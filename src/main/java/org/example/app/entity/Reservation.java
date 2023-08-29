package org.example.app.entity;

public class Reservation {

    private int id;
    private User userId;
    private Flight flightId;
    private int passenger;

    public Reservation() {
    }

    public Reservation(User userId, Flight flightId, int passenger) {
        this.userId = userId;
        this.flightId = flightId;
        this.passenger = passenger;

    }

    public Reservation(int id, User userId, Flight flightId, int passenger) {
        this.id = id;
        this.userId = userId;
        this.flightId = flightId;
        this.passenger = passenger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Flight getFlightId() {
        return flightId;
    }

    public void setFlightId(Flight flightId) {
        this.flightId = flightId;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", userId=" + userId.getId()+
                ", flightId=" + flightId.getId() +
                ", passenger=" + passenger +
                '}';
    }
}