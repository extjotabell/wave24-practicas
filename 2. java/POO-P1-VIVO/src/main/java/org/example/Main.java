package org.example;

import org.example.classes.Person;

public class Main {
    public static void main(String[] args) {

        Person PersonWithoutConstructor = new Person();

        Person PersonAnyConstructor = new Person("Imanol", 20, "45084386");

        Person PersonAllConstructor = new Person("Imanol", 20, "45084386", 80.2, 1.78);

    }
}