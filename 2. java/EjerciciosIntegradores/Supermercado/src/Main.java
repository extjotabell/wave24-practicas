import classes.Cliente;
import classes.Factura;
import classes.Producto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>(Arrays.asList(
                new Cliente(1, "Marcos", "Anzurez"),
                new Cliente(2, "Carlos", "Jimenez"),
                new Cliente(3, "Thomas", "Wayne")
        ));

        clientes.forEach(System.out::println);
        System.out.println("Borrando al primer cliente...");
        clientes.removeFirst();
        clientes.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese el DNI del cliente:");
        int dni = scanner.nextInt();

        Cliente clienteBuscado;

        if (clientes.stream().anyMatch(cliente -> cliente.getDni() == dni)) {
            clienteBuscado = clientes.stream().filter(cliente -> cliente
                    .getDni() == dni).findFirst().get();
        } else {
            System.out.println("El cliente no existe... \nIngrese el nombre del Cliente:");
            String nombre = scanner.next();
            System.out.println("Ingrese el apellido:");
            String apellido = scanner.next();

            clienteBuscado = new Cliente(dni, nombre, apellido);
            clientes.add(clienteBuscado);
        }

        Factura factura = new Factura(clienteBuscado, new ArrayList<>(Arrays.asList(
                new Producto("producto-1", "Arroz", 3, 19.90),
                new Producto("producto-2", "Galletas", 7, 17.50)
        )));

        System.out.println(factura.getTotalCompra());
    }
}