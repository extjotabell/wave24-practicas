package org.example.ejercicios.integrador;

import org.example.ejercicios.integrador.models.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Integrador {

    public static void main(){
        List<Cliente> clientes = new ArrayList<>();

        Cliente cliente1 = new Cliente("12345678", "Juan", "Perez");
        Cliente cliente2 = new Cliente("87654321", "María", "Gomez");
        Cliente cliente3 = new Cliente("55555555", "Carlos", "Rodriguez");

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        imprimirClientes(clientes);

        clientes.remove(2);

        imprimirClientes(clientes);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un dni para buscar un cliente");

        String dni = scanner.nextLine();
        Cliente cliente = consultarCliente(clientes, dni);
        if(cliente != null){
            System.out.println(cliente);
        }
        else {
            System.out.println("Cliente no encontrado");
        }

    }


    private static void imprimirClientes(List<Cliente> clientes){
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(clientes.get(i));
        }
    }

    private static Cliente consultarCliente(List<Cliente> clientes, String dni){
        for(Cliente cliente : clientes){
            if(cliente.getDni().equals(dni)){
                return cliente;
            }
        }
        return null;
    }

}
