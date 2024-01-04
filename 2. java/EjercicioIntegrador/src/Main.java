import classes.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Cliente clienteUno = new Cliente("11-1", "Joaquín", "Cabello");
        Cliente clienteDos = new Cliente("22-2", "Belén", "Araya");
        Cliente clienteTres = new Cliente("33-3", "Victor", "Rivas");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(clienteUno);
        clientes.add(clienteDos);
        clientes.add(clienteTres);

        System.out.println(clientes);
        clientes.remove(clienteUno);
        System.out.println(clientes);

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingresa DNI de cliente a buscar");
        String dniFind = scan.next();

        var clientsFind = clientes.stream().filter((client) -> client.getDni().equals(dniFind)).toList();

        if(clientsFind.isEmpty()){
            System.out.println("Cliente de DNI " + dniFind + " no encontrado");
            return;
        }

        System.out.println(clientsFind);
    }
}
