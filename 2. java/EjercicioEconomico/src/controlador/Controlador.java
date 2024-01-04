package controlador;

import modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controlador {

    public Controlador(){
        Cliente cliente1 = new Cliente("12335345-1", "N1", "A1");
        Cliente cliente2 = new Cliente("12543253-2", "N2", "A2");
        Cliente cliente3 = new Cliente("74765754-3", "N3", "A3");
        List<Cliente> listaCliente = new ArrayList<Cliente>();
        listaCliente.add(cliente1);
        listaCliente.add(cliente2);
        listaCliente.add(cliente3);

        for (Cliente cliente: listaCliente ){
            System.out.println(cliente);
        }

        listaCliente.remove(cliente3);
        for (Cliente cliente: listaCliente ){
            System.out.println(cliente);
        }

        System.out.println("Ingrese un número de dni de cliente: ");
        Scanner scanner = new Scanner(System.in);
        String dniBuscado = scanner.nextLine();

        try{
            buscarPorDni(dniBuscado, listaCliente);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public void buscarPorDni(String dni, List<Cliente> listaCliente){
        List<Cliente> clientesAux = listaCliente.stream().filter(c -> c.getDni().equals(dni)).toList();

        if(!clientesAux.isEmpty()){
            System.out.println("Cliente encontrado: " + clientesAux.get(0).toString());
        }
        else {
            throw new RuntimeException("Cliente no encontrado");
        }
    }
}
