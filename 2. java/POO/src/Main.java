import classes.Perecedero;
import classes.Person;
import classes.PracticaExcepciones;
import classes.Producto;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
//        // Person voidPerson = new Person();
//        // Person partialPerson = new Person("Joaquín", 25, "19850997-3");
//        Person completePerson = new Person("Joaquín", 25, "19850997-3", 64.5, 1.70);
//        System.out.println(completePerson);
//        // No se puede por falta de parametros, no coincide
//        // Person personWithoutDni = new Person("Nombre", 25);
//
//        // Ejemplo exceptions
//        int divisor = 0;
//        int number = 500;
//
//        try {
//            int dividendo = number / divisor;
//            System.out.println(dividendo);
//        } catch (ArithmeticException exception){
//            System.out.println("División con errores, no se puede dividir por 0");
//        }

//        PracticaExcepciones practica = new PracticaExcepciones();
//        practica.calcularCociente();

        Producto producto = new Producto("papas", 2000);
        producto.calcular(2);

        Perecedero perecedero = new Perecedero("atún", 2000, 3);
        System.out.println(perecedero.calcular(2));
    }
}
