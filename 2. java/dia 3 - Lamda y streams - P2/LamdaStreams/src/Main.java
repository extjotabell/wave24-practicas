import classes.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Abril", "Perez", 50, 40000D, "PASS-28828");
        Person person2 = new Person("Sandra", "Gomez", 3, 0D, "DNI-45999");
        Person person3 = new Person("Mariana", "Gregori", 22, 30000D, "DNI-35020");
        Person person4 = new Person("Juan", "Gonzalez", 85, 22000D, "ID-22222");
        Person person5 = new Person("Abril", "Smith", 9, 0D, "PASS-45002");

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

        // Ordenar personas por nombre
        var personListOrdered = personList.stream() // modelacion de datos para trabajar con ellos.
                .sorted(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName)) // trabajar con los datos
                .toList(); // collectar o obtener los datos en la forma deseada

        System.out.println(personListOrdered);

        // Obtener salario promedio. Salario promedio como integer

        var personAvgSalary = personList.stream() // modelacion
                        .mapToDouble(Person::getSalary) // modelacion
                        .average() // trabajando con los datos
                        .getAsDouble(); // obtencion en el formato que queramos

        //System.out.println(personAvgSalary);

        // Obtener las personas con pasaportes
        var personWithPassports = personList.stream()
                .filter(person -> person.getID().contains("PASS"))
                .toList();

        //System.out.println(personWithPassports);

        var personWithPassports2 = personList.stream()
                .filter(person -> {
                    var typeOfDocument = person.getID().split("-");

                    return typeOfDocument[0].equals("PASS");
                });

        // Obtener nombres de todos en la lista pero sin repeteciones

        var listOfNames = personList.stream()
                .map(Person::getLastName)
                //.distinct() tambien puede ser utilizado si en vez de un set quiero una list.
                .collect(Collectors.toSet());

        System.out.println(listOfNames);
    }
}