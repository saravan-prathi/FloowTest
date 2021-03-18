package com.floow.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Driver {
    private static int counter = 1;
    private int driverID;
    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("lastname")
    private String lastName;
    @JsonProperty("date_of_birth")
    private LocalDate dateOfBirth;
    private LocalDate creationDate;

    public Driver() {
    }

    public Driver(String firstName, String lastName, LocalDate dateOfBirth) {
        this.driverID = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.creationDate = LocalDate.now();
    }

    public Driver(int driverID, String firstName, String lastName, LocalDate dateOfBirth, LocalDate creationDate) {
        this.driverID = driverID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return driverID + "," + firstName + "," + lastName + "," + dateOfBirth + "," + creationDate;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
