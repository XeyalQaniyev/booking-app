package org.example.app.constant;

public enum LoginRegister {
    LOGIN(1,"Log in"),
    REGISTRATION(2,"Registration");
    private final String description;
    private final int index;

    LoginRegister(int index, String description) {
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
