import classes.Person;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Nombre de clase - nombre de la variable = new - el constructor
        Person person1 = new Person("Jean", "Cardo", LocalDate.of(1960, 5, 9));
        // Calculo la edad gracias al metodo calculateAge
        person1.calculateAge();
        // muestro los datos completos de la persona
        System.out.println(person1);

        String something = "Hola, como estas?";

        // Hago a la clase hablar pasandole un parametro a talk()
        person1.talk(something);
    }
}