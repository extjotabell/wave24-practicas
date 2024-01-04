package controlador;

import modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controlador {

    public Controlador () {

        Cliente cliente = new Cliente("123","Juan","Perez");
        Cliente cliente1 = new Cliente("456","Maria","Gomez");
        Cliente cliente2 = new Cliente("789","Pedro","Gonzalez");

        List<Cliente> clientes = new ArrayList<Cliente>();

        clientes.add(cliente);
        clientes.add(cliente1);
        clientes.add(cliente2);

        for (Cliente c : clientes) {
            System.out.println(c.toString());
        }

        clientes.remove(1);

        for (Cliente c : clientes) {
            System.out.println(c.toString());
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el dni del cliente a buscar: ");
        String dni = sc.nextLine();

        try {
            buscarPorDni(dni, clientes);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }


    public void buscarPorDni(String dni, List<Cliente> clientes) {

        List<Cliente> clientesAux = clientes.stream().filter(c -> c.getDni().equals(dni)).toList();

        if (!clientesAux.isEmpty()) {
            System.out.println("Cliente encontrado: " + clientesAux.get(0).toString());
        } else {
            throw new RuntimeException("Cliente no encontrado");
        }

    }

}
