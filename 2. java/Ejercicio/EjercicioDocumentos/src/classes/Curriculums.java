package classes;

import classes.interfaces.IDocuments;

import java.util.ArrayList;

public class Curriculums extends Document {
    private String firstName;
    private String lastName;
    private int age;
    private String dni;
    private ArrayList<String> skills;

    public Curriculums(String firstName, String lastName, int age, String dni) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dni = dni;
        this.skills = new ArrayList<>();
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    @Override
    public String toString() {
        return "Curriculums{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }


    @Override
    public void print() {
        printTypeDoc();
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Age: " + age);
        System.out.println("DNI: " + dni);
        skills.forEach(System.out::println);

    }
}
