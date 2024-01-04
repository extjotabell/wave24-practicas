package clases;

import clases.interfaces.Crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supermercado implements Crud {

    Scanner teclado = new Scanner(System.in);
    private List<Cliente> listaClientes;
    private List<Factura> listaFacturas;

    public Supermercado(List<Cliente> listaClientes, List<Factura> listaFacturas) {

        this.listaClientes = listaClientes;
        this.listaFacturas = listaFacturas;
    }

    //Clientes
    public List<Cliente> listarClientes() {
        return listaClientes;
    }
    public void altaCliente(Scanner teclado) {
        System.out.println("Ingrese el DNI del nuevo cliente: ");
        int dni = teclado.nextInt();

        if (buscar(dni) != null ) {
            System.out.println("Ya existe un cliente con ese DNI.");
        }else{
            System.out.println("Ingrese el nombre del nuevo cliente: ");
            String nombre = teclado.next();

            System.out.println("Ingrese el apellido del nuevo cliente: ");
            String apellido = teclado.next();

            Cliente nuevoCliente = new Cliente(dni, nombre, apellido);

            alta(nuevoCliente);
        }
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

        return null;
    }


    @Override
    public Cliente modificar(int dni) {
        Cliente cliente = (Cliente) buscar(dni);
        if(cliente != null){
            System.out.println("Datos actuales del cliente: ");
            System.out.println("Seleccione el dato que desea editar:");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido");


        int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nuevo nombre del cliente:");
                    String nuevoNombreCliente = teclado.next();
                    cliente.setNombreCliente(nuevoNombreCliente);
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo apellido del cliente:");
                    String nuevoApellidoCliente = teclado.next();
                    cliente.setApellidoCliente(nuevoApellidoCliente);
                    break;
                default:
                    System.out.println("Opción no valida. No se realizaron cambios.");
                    break;
            }
            System.out.println("Cliente actualizado con exito:");
        }
        return cliente;
    }


    //Facturas
    public List<Factura> listarFacturas() {
        return listaFacturas;
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
        listaFacturas.add(nuevaFactura);
    }


    //Productos
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
