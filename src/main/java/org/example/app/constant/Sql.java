package org.example.app.constant;

public enum Sql {
    DB_URL( "jdbc:postgresql://localhost:5432/bookingapp"),
    ADD_FLIGHT("INSERT INTO \"Flight\" (seats, number, airline, destination, departure_city, " +
            "departure_time, arrival_time, gate, terminal, status, counter, boarding_time) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"),
    GET_FLIGHT_BY_ID("SELECT * FROM \"Flight\" WHERE id = ?"),
    GET_ALL_FLIGHT("SELECT * FROM \"Flight\""),
    GET_ALL_FLIGHT_BY_USER_ID("select u.id,f.* from \"Reservation\" r\n" +
            "left join \"User\" u on r.user_id = u.id\n" +
            "left join \"Flight\" f on r.flight_id = f.id\n" +
            "having u.id = ?"),
    CANCEL_FLIGHT("delete from \"Reservation\" where flight_id = ? and user_id =?"),
    BOOKING_FLIGHT("insert into \"Reservation\" (user_id, flight_id, passenger) VALUES (?,?,?)"),
    GET_PASSENGER("select * from \"Reservation\" where flight_id = ? and user_id =?"),
    GET_SEAT("select seats from \"Flight\" where id = ?"),
    UPDATE_SEAT("update \"Flight\" set seats = seats + ? where id = ?"),
    UPDATE_SEAT_MINUS("update \"Flight\" set seats = seats - ? where id = ?"),
    GET_ALL_USER("select * from \"User\" "),
    ADD_USER("insert into \"User\"(name,surname,age,password,user_name) values(?,?,?,?,?)"),
    GET_USER_BY_ID("select * from \"User\" where id = ?"),
    SHOW_MY_FLIGHT("SELECT f.* FROM \"Flight\" f " +
            "JOIN \"Reservation\" r ON f.id = r.flight_id " +
            "WHERE r.user_id = ?"),

    ;



    private final String value;

    Sql(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
