package org.example.app.constant;

public enum SearchAndBook {
    SEARCH(1,"Search"),
    BOOK(2,"Reservation");
    private final String description;
    private final int index;

    SearchAndBook(int index, String description) {
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
