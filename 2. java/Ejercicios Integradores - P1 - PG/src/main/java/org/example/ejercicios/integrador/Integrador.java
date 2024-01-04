package org.example.ejercicios.integrador;

import org.example.ejercicios.integrador.models.Cliente;

import java.util.ArrayList;
import java.util.List;

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

    }


    private static void imprimirClientes(List<Cliente> clientes){
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(clientes.get(i));
        }
    }

}
