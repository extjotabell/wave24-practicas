import classes.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Person persona = new Person("Joaco", "Cabello", 25, 200D, "PASS 12");
        Person persona1 = new Person("Nicolas", "Palominos", 20, 0D, "123");
        Person persona2 = new Person("Belen", "Palominos", 2, 200D, "PASS 1232");
        Person persona3 = new Person("Nataly", "Palominos", 28, 100D, "12121");
        Person persona4 = new Person("Victor", "Rivas", 30, 100D, "098");

        List<Person> personas = new ArrayList<>();
        personas.add(persona);
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);
        personas.add(persona4);

        // order by name asc
        var personsOrderedASC = personas.stream().sorted(Comparator.comparing(Person::getFirstName)).toList();
        System.out.println(personsOrderedASC);

        var personsOrderedDSC = personas.stream().sorted(Comparator.comparing(Person::getFirstName).reversed()).toList();
        System.out.println(personsOrderedDSC);

        // salario promedio
        // mapToDouble es un map normal que se le suman algunos metodos especificos numericos
        var promedio = personas.stream().mapToDouble(Person::getSalary).average().getAsDouble();
        System.out.println(promedio);

        var personsFiltered = personas.stream().filter(person -> person.getEdad() > 20).toList();
        System.out.println(personsFiltered);

        var personsWithPassport = personas.stream().filter(person -> person.getId().contains("PASS")).toList();
        System.out.println(personsWithPassport);
    }
}
