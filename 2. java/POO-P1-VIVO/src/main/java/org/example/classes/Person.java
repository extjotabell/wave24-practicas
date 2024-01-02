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

    public Integer caculateIMC() {
        double result = weight / (Math.pow(height, 2));
        if (result < 20) {
            return -1;
        }
        else if (result >= 20 && result <= 25) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public Boolean isHolder(){
        return age >= 18;
    }

    @Override
    public String toString() {
        return
                " nombre= " + name + '\n' +
                " edad= " + age + '\n' +
                " dni= " + dni + '\n' +
                " peso= " + weight + " Kg" + '\n' +
                " altura= " + height + " Mts";
    }
}
