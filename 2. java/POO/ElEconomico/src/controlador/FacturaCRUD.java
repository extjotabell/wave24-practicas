package controlador;

import modelo.Cliente;
import modelo.Factura;
import modelo.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FacturaCRUD {

    List<Factura> facturas;
    List<Item> items;

    List<Cliente> clientes;

    public FacturaCRUD(List<Factura> facturas, List<Item> items, List<Cliente> clientes) {
        this.facturas = facturas;
        this.items = items;
        this.clientes = clientes;
        Scanner sc = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {
            System.out.println("1. Crear factura");
            System.out.println("2. Leer factura");
            System.out.println("3. Actualizar factura");
            System.out.println("4. Borrar factura");
            System.out.println("5. Salir");
            System.out.println("Introduce una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    crearFactura();
                    break;
                case 2:
                    System.out.println("Introduce el dni del cliente a buscar: ");
                    String dni = sc.nextLine();
                    leerFactura(dni);
                    break;
                case 3:
                    actualizarFactura();
                    break;
                case 4:
                    borrarFactura();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    public void crearFactura() {
        Scanner sc = new Scanner(System.in);
        Factura factura = new Factura();
        System.out.println("Introduce el dni del cliente: ");
        String dni = sc.nextLine();
        clientes.stream().filter(cliente -> cliente.getDni().equals(dni)).findFirst().ifPresent(cliente -> {
            factura.setCliente(cliente);
            boolean salir = false;
            List<Item> itemsAux = new ArrayList<>();
            List<Integer> cantidadesAux = new ArrayList<>();
            while (!salir) {
                System.out.println("Introduce el codigo del item: ");
                int codigo = Integer.parseInt(sc.nextLine());
                System.out.println("Introduce la cantidad del item: ");
                int cantidad = Integer.parseInt(sc.nextLine());
                items.stream().filter(item -> item.getCodigo() == codigo).findFirst().ifPresent(item -> {
                    itemsAux.add(item);
                    cantidadesAux.add(cantidad);
                });
                System.out.println("¿Quieres añadir otro item? (s/n)");
                String respuesta = sc.nextLine();
                if (respuesta.equals("n")) {
                    salir = true;

                }
                factura.setItems(itemsAux);
                factura.setCantidades(cantidadesAux);
            }
        });
        facturas.add(factura);

    }

    public void leerFactura(String dni) {

    }

    public void actualizarFactura() {

    }

    public void borrarFactura() {

    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
