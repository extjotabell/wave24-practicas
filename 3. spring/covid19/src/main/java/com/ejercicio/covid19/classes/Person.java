package com.ejercicio.covid19.classes;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private Integer id;
    private String firstName;
    private String lastName;
    private int age;
    private ArrayList<Symptom> symptoms;

    public Person() {
    }


    public Person(Integer id, String firstName, String lastName, int age, ArrayList<Symptom> symptoms) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.symptoms = symptoms;
    }

    public Integer getId() {
        return id;
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

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
