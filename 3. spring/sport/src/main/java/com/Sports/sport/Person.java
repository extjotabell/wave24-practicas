package com.Sports.sport;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String sport;


    public Person(String firstName, String lastName, String age, String sport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = Integer.parseInt(age);
        this.sport = sport;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getSport() {
        return sport;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sport=" + sport +
                '}';
    }
}
