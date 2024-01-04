package controlador;

import modelo.Cliente;

import java.util.List;
import java.util.Scanner;

public class ClienteCRUD {

    List<Cliente> clientes;
    public ClienteCRUD(List<Cliente> clientes) {
        this.clientes = clientes;
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("1. Crear cliente");
            System.out.println("2. Leer cliente");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Borrar cliente");
            System.out.println("5. Salir");
            System.out.println("Introduce una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    crearCliente();
                    break;
                case 2:
                    System.out.println("Introduce el dni del cliente a buscar: ");
                    String dni = sc.nextLine();
                    leerCliente(dni);
                    break;
                case 3:
                    actualizarCliente();
                    break;
                case 4:
                    borrarCliente();
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

    public void crearCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el dni del cliente: ");
        String dni = sc.nextLine();
        System.out.println("Introduce el nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce el apellido del cliente: ");
        String apellido = sc.nextLine();
        clientes.add(new Cliente(dni, nombre, apellido));
    }

    public void leerCliente(String dni) {

    }

    public void actualizarCliente() {

    }

    public List<Cliente> borrarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el dni del cliente a borrar: ");
        String dni = sc.nextLine();
        clientes.removeIf(c -> c.getDni().equals(dni));
        return clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
