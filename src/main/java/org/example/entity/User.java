package org.example.entity;

import java.util.List;
import java.util.Objects;

public class User {

    private long id;
    private String name;
    private String surname;
    private int age;
    private List<Flight> myFlight;

    public User(long id, String name, String surname, int age, List<Flight> myFlight) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.myFlight = myFlight;
    }

    public User(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Flight> getMyFlight() {
        return myFlight;
    }

    public void setMyFlight(List<Flight> myFlight) {
        this.myFlight = myFlight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getId() == user.getId() && getAge() == user.getAge() && Objects.equals(getName(),
                user.getName()) && Objects.equals(getSurname(), user.getSurname()) && Objects.equals(getMyFlight(),
                user.getMyFlight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getAge(), getMyFlight());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", myFlight=" + myFlight +
                '}';
    }
}
