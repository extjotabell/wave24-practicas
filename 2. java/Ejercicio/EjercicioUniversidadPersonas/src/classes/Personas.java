package classes;

import interfaces.IPersonas;

public abstract class Personas implements IPersonas {

    public String firstName;
    public String lastName;
    public String identificationDocument;
    public int age;

    public Personas(String firstName, String lastName, String identificationDocument, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationDocument = identificationDocument;
        this.age = age;
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

    public String getIdentificationDocument() {
        return identificationDocument;
    }

    public void setIdentificationDocument(String identificationDocument) {
        this.identificationDocument = identificationDocument;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Personas{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", identificationDocument='" + identificationDocument + '\'' +
                ", age=" + age +
                '}';
    }
}
