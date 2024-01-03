import clases.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        List<Cliente> listaClientes = new ArrayList<>();

        Cliente cliente1 = new Cliente(40392862, "Maria", "Perez");
        Cliente cliente2 = new Cliente(35685280, "Romina", "Gonzalez");
        Cliente cliente3 = new Cliente(17654234, "Marcos", "Rodriguez");

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        int opcion = 0;
        do{
            //Menu
            System.out.println(" ");
            System.out.println("1- Visualizar la lista de clientes con sus datos");
            System.out.println("2- Eliminar un cliente");
            System.out.println("3- Buscar cliente");
            System.out.println("4- Salir");
            System.out.println("Ingrese su opcion: ");

            opcion = teclado.nextInt();

            switch (opcion){
                case 1:
                    if(listaClientes.isEmpty()){
                        System.out.println("No se encontro ningun cliente.");
                    }
                    else {
                        for(Cliente clientes : listaClientes) {
                            System.out.println(clientes);
                        }
                    }
                    break;
                case 2:
                    if(listaClientes.isEmpty()){
                        System.out.println("No se encontro ningun cliente");
                    }
                    else{
                        System.out.println("\nIngrese el DNI del cliente que desea eliminar.");
                        int eliminarCliente = teclado.nextInt() ;

                        //Busco el cliente
                        Cliente clienteEliminar = null;
                        for(Cliente cliente : listaClientes){
                            if(cliente.getDni() == eliminarCliente){
                                clienteEliminar = cliente;
                            }
                        }

                        //Elimino el cliente
                        if(clienteEliminar != null){
                            listaClientes.remove(clienteEliminar);
                            System.out.println("Se ha eliminado con éxito el cliente");
                            System.out.println("\nNuevo listado de clientes");
                            if(listaClientes.isEmpty()){
                                System.out.println("No se encontro ningun cliente.");

                            }
                            else {
                                for(Cliente clientes : listaClientes) {
                                    System.out.println(clientes);
                                }
                            }
                        }else{
                            System.out.println("No se encontro el cliente que se desea eliminar.");
                        }
                    }
                    break;
                case 3:
                    if(listaClientes.isEmpty()){
                        System.out.println("No se encontro ningun cliente");
                    }
                    else{
                        System.out.println("\nIngrese el DNI del cliente que desea eliminar.");
                        int buscarCliente = teclado.nextInt() ;

                        //Busco el cliente
                        Cliente clienteBuscado = null;
                        for(Cliente cliente : listaClientes){
                            if(cliente.getDni() == buscarCliente){
                                clienteBuscado = cliente;
                            }
                        }
                        if(clienteBuscado != null){
                            System.out.println(clienteBuscado.toString());
                        }else{
                            System.out.println("No se encontro el cliente.");
                        }
                    }
                        break;

            }
        }while (opcion != 4);


    }
}