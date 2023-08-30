package org.example.app.constant;

public enum Menu {
    BOARD(1, "Online-board"),
    SHOW(2, "Show the flight info"),
    SEARCH(3, "Search and book a flight"),
    CANCEL(4, "Cancel the booking"),
    My_FLIGHT(5, "My flights"),
    EXIT(6, "EXIT");

    private final String description;
    private final int index;

    Menu(int index, String description) {
        this.index = index;
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
}
}
