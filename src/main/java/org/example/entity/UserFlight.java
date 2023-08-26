package org.example.entity;

public class UserFlight {
    private int id;
    private User user_id;
    private Flight flight_id;

    public UserFlight() {
    }

    public UserFlight(int id, User user_id, Flight flight_id) {
        this.id = id;
        this.user_id = user_id;
        this.flight_id = flight_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Flight getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Flight flight_id) {
        this.flight_id = flight_id;
    }

    @Override
    public String toString() {
        return "UserFlightImpl{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", flight_id=" + flight_id +
                '}';
    }
}
