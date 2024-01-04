import classes.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("1","Pedro","Perez"));
        clientes.add(new Cliente("2","Juan","Sanchez"));
        clientes.add(new Cliente("3","Andres","Ramirez"));

        System.out.println("Todos los clientes: ");
        clientes.forEach(System.out::println);
        clientes.remove(2);
        System.out.println("Los clientes luego de remover a uno: ");
        clientes.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar el dni de un cliente: ");
        String dni = scanner.nextLine();

        Optional<Cliente> optionalCliente = clientes.stream().filter(x -> x.getDni().equals(dni)).findFirst();
        if(optionalCliente.isPresent()){
            System.out.println(optionalCliente.get().toString());
        }else{
            System.out.println("El dni no está registrado en ningún cliente.");
        }

    }
}
