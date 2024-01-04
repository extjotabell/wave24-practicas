package org.example.ejercicios.integrador;

import org.example.ejercicios.integrador.models.Cliente;
import org.example.ejercicios.integrador.models.Factura;
import org.example.ejercicios.integrador.models.Item;

import java.util.*;

public class Integrador {

    List<Cliente> clientes = new ArrayList<>();

    public void main(){


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
        if(cliente == null){
            System.out.println("Cliente no encontrado");
        }
        Factura factura = crearFactura(cliente1);
        System.out.println("Factura creada: ");
        System.out.println(factura);

    }

    private Factura crearFactura(Cliente cliente) {
        Factura factura = new Factura();
        factura.setCliente(cliente);
        factura.setItems(crearItems());
        factura.setTotal(factura.caclularTotal());
        return factura;
    }

    private List<Item> crearItems() {
            List<Item> items = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);

            boolean terminar = false;

            while (!terminar){
                System.out.println("Ingrese el nombre del producto: ");
                String nombre = scanner.nextLine();

                System.out.println("Ingrese la cantidad del producto: ");
                Long cantidad = scanner.nextLong();

                System.out.println("Ingrese el precio del producto: ");
                Double costo = scanner.nextDouble();

                UUID codigo = UUID.randomUUID();


                Item item = new Item(codigo, nombre, cantidad, costo);
                items.add(item);

                System.out.println("Se a agregado el producto");
                System.out.println("Desea agregar otro producto: (Y: si | N: no)");
                scanner.nextLine();
                String respuesta = scanner.nextLine();
                terminar = Objects.equals(respuesta, "Y");
            }
            return items;
    }


    private void imprimirClientes(List<Cliente> clientes){
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    private Cliente consultarCliente(List<Cliente> clientes, String dni){
        for(Cliente cliente : clientes){
            if(cliente.getDni().equals(dni)){
                return cliente;
            }
        }
        return null;
    }

}
