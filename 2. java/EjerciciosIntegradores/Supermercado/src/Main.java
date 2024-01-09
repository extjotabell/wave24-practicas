import classes.Cliente;

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

        var clienteBuscado = clientes.stream().anyMatch(cliente -> cliente.getDni() == dni) ? clientes.stream().filter(cliente -> cliente
                .getDni() == dni).findFirst().get() : "El cliente no existe";
        System.out.println(clienteBuscado);
    }
}