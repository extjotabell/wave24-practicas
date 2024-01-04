import model.Cliente;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(new Cliente("1234", "Pepito", "Perez"));
        clientes.add(new Cliente("4567", "Fulano", "Rodriguez"));
        clientes.add(new Cliente("5678", "Mengano", "Funes"));

        System.out.println("Lista de clientes");
        clientes.forEach(cliente -> System.out.println(cliente.toString()));

        System.out.println("Lista de clientes");
        clientes.remove(0);
        clientes.forEach(cliente -> System.out.println(cliente.toString()));

        Scanner sc = new Scanner(System.in);
        String dni = sc.nextLine();

        String clienteEncontrado = clientes.stream().filter(cliente -> cliente.getDni().equals(dni)).map()toString();
        System.out.println(clienteEncontrado);

    }
}