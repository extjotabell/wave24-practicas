package org.example;

public class Participant {
    int registrationNumber;
    int dni;
    String name;
    String lastName;
    int age;
    String cellphone;
    String emergencyNumber;
    String bloodGroup;

    Participant(int registrationNumber, int dni, String name, String lastName, int age, String cellphone, String emergencyNumber, String bloodGroup) {
        this.registrationNumber = registrationNumber;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.cellphone = cellphone;
        this.emergencyNumber = emergencyNumber;
        this.bloodGroup = bloodGroup;
    }
}
