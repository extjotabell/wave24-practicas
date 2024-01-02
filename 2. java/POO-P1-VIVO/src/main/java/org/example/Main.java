package org.example;

import org.example.classes.Person;

public class Main {
    public static void main(String[] args) {

        Person personWithoutConstructor = new Person();

        Person personAnyConstructor = new Person("Imanol", 20, "45084386");

        Person personAllConstructor = new Person("Imanol", 20, "45084386", 80.2, 1.78);

        System.out.println("Persona: ");
        System.out.println(personAllConstructor.toString());

        double indexIMC = personAllConstructor.caculateIMC();

        String IMC = "";
        if (indexIMC == -1){
            IMC = "Bajo peso";
        } else if (indexIMC == 0) {
            IMC = "Peso saludable";
        }
        else {
            IMC = "Sobrepeso";
        }

        System.out.println("IMC: " + IMC);

        System.out.println("Es mayor de edad: " + personAllConstructor.isHolder());
    }
}