package supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Crear 3 clientes
        Cliente cliente1 = new Cliente("Juan", "Perez", "12345678");
        Cliente cliente2 = new Cliente("Maria", "Gomez", "87654321");
        Cliente cliente3 = new Cliente("Carlos", "Gutierrez", "11223344");

        List<Cliente> clientes = new ArrayList<>(List.of(cliente1, cliente2, cliente3));

        // Mostar los clientes
        System.out.println("Clientes:");
        clientes.forEach(cliente -> System.out.println(cliente.toString()));

        // Eliminar un cliente
        System.out.println("\nEliminando un cliente:");
        clientes.remove(cliente1);
        clientes.forEach(cliente -> System.out.println(cliente.toString()));

        // Solicitar un cliente por DNI
        System.out.println("\nIngresa un DNI:");
        Scanner console = new Scanner(System.in);
        String dni = console.nextLine();

        Cliente cliente = clientes.stream().filter(c -> c.getDni().equals(dni)).findFirst().orElse(null);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente.toString());
        } else {
            System.out.println("Cliente no encontrado");
        }
    }
}
