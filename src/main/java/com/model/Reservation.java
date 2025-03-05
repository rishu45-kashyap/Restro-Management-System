package com.model;

public class Reservation {
    private int id;
    private String name;
    private String email;
    private String dateTime;
    private int people;
    private String specialRequest;

    // Constructor
    public Reservation(int id, String name, String email, String dateTime, int people, String specialRequest) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateTime = dateTime;
        this.people = people;
        this.specialRequest = specialRequest;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getDateTime() { return dateTime; }
    public int getPeople() { return people; }
    public String getSpecialRequest() { return specialRequest; }
}
