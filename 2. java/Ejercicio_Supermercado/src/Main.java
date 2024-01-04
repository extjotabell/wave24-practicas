import classes.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Juan", "Perez", "12345678");
        Cliente cliente2 = new Cliente("Ignacio", "Collado", "12345679");
        Cliente cliente3 = new Cliente("Anakin", "Skywalker", "12345610");

        List<Cliente> clientes = new ArrayList<>(List.of(cliente, cliente2, cliente3));

        System.out.println(clientes);

        //Eliminar cliente por dni
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el dni del cliente a eliminar: ");

        String dniBorrar = scanner.nextLine();

        boolean removed = clientes.removeIf(c -> c.getDni().equals(dniBorrar));

        if (removed) {
            System.out.println("El cliente fue eliminado");
        } else {
            System.out.println("El cliente no existe");
        }

        System.out.println(clientes);

        //Solicitar dni por teclado

        System.out.println("Ingrese el dni del cliente a buscar: ");

        String dniBuscar = scanner.nextLine();

        //Buscar cliente por dni
        Cliente clienteBuscado = clientes.stream()
                .filter(c -> c.getDni().equals(dniBuscar))
                .findFirst()
                .orElse(null);

        if (clienteBuscado != null) {
            System.out.println("El cliente buscado es: " + clienteBuscado);
        } else {
            System.out.println("El cliente no existe");
        }

    }
}