package classes;

public class Person {

    // Attributes
    String name;
    int age;
    String dni;
    int weight;
    double height;

    //Constructors
    public Person() {
    }

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, int age, String dni, int weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }
}
