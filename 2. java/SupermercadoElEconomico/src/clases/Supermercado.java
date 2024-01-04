package clases;

import clases.interfaces.Crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supermercado implements Crud {

    Scanner teclado = new Scanner(System.in);
    private List<Cliente> listaClientes;
    private List<Factura> listaFacturas;

    public Supermercado(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }


    @Override
    public void alta(Object elemento) {
        listaClientes.add((Cliente) elemento);
        System.out.println("Se ha agregado un cliente");
    }

    @Override
    public void baja(int dni) {
        //Busco el cliente
        Cliente clienteEliminar = null;
        for(Cliente cliente : listaClientes){
            if(cliente.getDni() == dni){
                clienteEliminar = cliente;
            }
        }

        //Elimino el cliente
        if(clienteEliminar != null){
            listaClientes.remove(clienteEliminar);
            System.out.println("Se ha eliminado el cliente");
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

    @Override
    public Object buscar(int dni) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getDni() == dni) {
                System.out.println(cliente);
                return cliente;
            }
        }

        System.out.println("No se encontró el cliente.");
        return null;
    }

    @Override
    public void modificar(Object elemento) {

    }

    @Override
    public List listar() {
        return listaClientes;
    }

    public void crearFactura(Scanner teclado){
        System.out.println("Ingrese el DNI del cliente para la factura:");
        int dniCliente = teclado.nextInt();
        Cliente cliente = (Cliente) buscar(dniCliente);

        if (cliente == null) {
            System.out.println("No se encontro al cliente, no se puede crear la factura.");
            return;
        }

        List<Item> productosFactura = new ArrayList<>();
        String agregarOtroProducto;

        do {
            productosFactura.add(agregarOtroProducto(teclado));
            System.out.println("Desea agregar otro item? (si/no): ");
            agregarOtroProducto = teclado.next();
        } while (agregarOtroProducto.equals("si"));

        Factura nuevaFactura = new Factura(cliente, productosFactura);

        System.out.println("Se ha creado la factura:");
        System.out.println(nuevaFactura);
    }

    private Item agregarOtroProducto(Scanner teclado) {
        System.out.println("Ingrese el codigo del producto:");
        String codigo = teclado.next();

        System.out.println("Ingrese el nombre del producto:");
        String nombre = teclado.next();

        System.out.println("Ingrese la cantidad comprada del producto:");
        int cantidad = teclado.nextInt();

        System.out.println("Ingrese el costo unitario del producto:");
        double costoUnitario = teclado.nextDouble();

        return new Item(codigo, nombre, cantidad, costoUnitario);
    }
}
