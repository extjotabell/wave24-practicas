package classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {
    // atributos
    String firstName;

    String lastName;

    LocalDate birthDate;

    long age;

    // constructores

    // constructor vacio.
    public Person(){

    }

    public Person(String firstName, String lastName, LocalDate birthDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    // metodos comunes

    public void talk(String something){
        System.out.println(something);
    }

    public void calculateAge(){
        this.age = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", age=" + age +
                '}';
    }
}
