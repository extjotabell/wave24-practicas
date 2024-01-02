package org.example.classes;

public class Person {
    String name;
    int age;
    String dni;
    double weight;
    double height;

    public  Person() {}

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }
}
