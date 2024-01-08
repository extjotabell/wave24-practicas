import classes.Cliente;
import classes.Factura;
import classes.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static final void main(String[] args) {
        // Crear 3 clientes y guardarlos en una collection
        Cliente cliente1 = new Cliente("123", "nombre1", "apellido1");
        Cliente cliente2 = new Cliente("345", "nombre2", "apellido3");
        Cliente cliente3 = new Cliente("567", "nombre2", "apellido3");

        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        // Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos.
        listaClientes.stream()
                .forEach(cliente -> System.out.println(cliente.toString()));

        // Obtener cualquier cliente de la lista y eliminarlo si está presente
        Optional<Cliente> clienteAEliminar = listaClientes.stream().findAny();
        clienteAEliminar.ifPresent(listaClientes::remove);

        //Imprimir si esta presente.
        listaClientes.stream()
                .forEach(cliente -> System.out.println(cliente.toString()));

        //Solicitar por teclado un DNI para buscarlo. Si está en la lista, mostrar sus datos y si no
        //mostrar un mensaje informando la situacion.
        String dniTeclado;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese DNI del cliente a encontrar: ");
        dniTeclado = teclado.next();
        teclado.close();
        var clientesEncontrados = listaClientes.stream()
                .filter(cliente -> cliente.getDni().equals(dniTeclado))
                .toList();

        if (!clientesEncontrados.isEmpty()) {
            System.out.println("Cliente encontrado: " + clientesEncontrados);
        } else {
            System.out.println("Cliente con DNI " + dniTeclado + " no encontrado.");
        }

        //Parte 2
        //Crear una nueva factura

        System.out.println("Creando factura para el cliente 2 con DNI 345...");

        //Primero crear un item para poner en la factura
        Item item1 = new Item("123", "item1", 1, 1000.0);
        Item item2 = new Item("456", "item2", 2, 2000.0);

        System.out.println("Items Creados: ");
        System.out.println("Item1: " + item1.toString());
        System.out.println("Item2: " + item2.toString());

        //Crear ArrayList para los items
        ArrayList<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        //El campo total es un campo calculado, se debe calcular al momento de crear la factura.
        Double contadorItems = 0.0;
        Double totalCompra = items.stream().mapToDouble(item -> item.getCostoUnitario()).sum();


        //Previo a agregar la factura a la coleccion de facturas hay que validar si el cliente existe en la lista de clientes.
        //Si no, se debe crear el mismo
        Optional<Cliente> validarCliente = listaClientes.stream()
                .filter(cliente -> cliente.getDni().equals(cliente2.getDni()))
                .findAny();


        if (validarCliente.isPresent()) {
            //Crear la factura
            Factura factura1 = new Factura(cliente2, items, totalCompra);
            System.out.println("Factura creada: " + factura1.toString());
        } else {
            listaClientes.add(cliente2);
            System.out.println("Cliente agregado a la lista de clientes y factura no emitida: " + cliente1.toString());
        }

    }
}
