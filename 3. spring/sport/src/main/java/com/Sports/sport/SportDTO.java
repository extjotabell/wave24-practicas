package com.Sports.sport;

public class SportDTO {

    private String firstName;
    private String lastName;
    private String sportName;

    public SportDTO(String firstName, String lastName, String sportName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sportName = String.valueOf(sportName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSportName() {
        return sportName;
    }
}
