package org.example.app.constant;

public enum FilePath {
    FLIGHT_LIST_DOC("C:\\Users\\user\\IdeaProjects\\booking-app\\doc\\FlightList.json");

    private final String value;

    FilePath(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
