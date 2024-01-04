import clases.Cliente;
import clases.Factura;
import clases.Item;
import clases.Supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElEconomico {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        List<Cliente> listaClientes = new ArrayList<>();
        List<Factura> listaFacturas = new ArrayList<>();
        List<Item> listaProductos = new ArrayList<>();

        Cliente cliente1 = new Cliente(40392862, "Maria", "Perez");
        Cliente cliente2 = new Cliente(35685280, "Romina", "Gonzalez");
        Cliente cliente3 = new Cliente(17654234, "Marcos", "Rodriguez");

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        Item productos1 = new Item("123123","atun", 5, 3200.00);
        Item productos2 = new Item("234234","salsa", 1, 1500.00);
        listaProductos.add(productos1);
        listaProductos.add(productos2);

        Factura factura1 = new Factura(cliente1, listaProductos);
        listaFacturas.add(factura1);

        Supermercado supermercado = new Supermercado(listaClientes, listaFacturas);

        int opcion = 0;
        do{
            //Menu
            System.out.println("Menu: ");
            System.out.println("1- Visualizar la lista de clientes con sus datos");
            System.out.println("2- Agregar un cliente.");
            System.out.println("3- Modificar un cliente");
            System.out.println("4- Eliminar un cliente");
            System.out.println("5- Buscar cliente");
            System.out.println("6- Visualizar lista de facturas.");
            System.out.println("7- Crear nueva factura");
            System.out.println("8- Salir");
            System.out.println("Ingrese su opcion: ");

            opcion = teclado.nextInt();

            switch (opcion){
                case 1:
                    List<Cliente> clientes = supermercado.listarClientes();
                    if (clientes.isEmpty()) {
                        System.out.println("No se encontro ningun cliente.");
                    } else {
                        for (Cliente cliente : clientes) {
                            System.out.println(cliente);
                        }
                    }
                    break;
                case 2:
                    supermercado.altaCliente(teclado);
                    clientes = supermercado.listarClientes();
                    if (clientes.isEmpty()) {
                        System.out.println("No se encontro ningún cliente.");
                    } else {
                        for (Cliente cliente : clientes) {
                            System.out.println(cliente);
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nIngrese el DNI del cliente que desea modificar:");
                    int dniBuscar = teclado.nextInt();
                    var cliente = supermercado.modificar(dniBuscar);
                    if(cliente != null){
                        System.out.println(cliente);
                    }
                    break;
                case 4:
                    System.out.println("\nIngrese el DNI del cliente que desea eliminar:");
                    int dniEliminar = teclado.nextInt();
                    supermercado.baja(dniEliminar);

                    break;
                case 5:
                    System.out.println("\nIngrese el DNI del cliente que desea buscar:");
                    dniBuscar = teclado.nextInt();
                    var clienteBuscado = supermercado.buscar(dniBuscar);
                    if(clienteBuscado==null){
                        System.out.println("No se encontro ningun cliente");
                    }
                        break;
                case 6:
                    List<Factura> facturas = supermercado.listarFacturas();
                    if (facturas.isEmpty()) {
                        System.out.println("No se encontró ninguna factura.");
                    } else {
                        for (Factura factura : facturas) {
                            System.out.println(factura);
                        }
                    }
                    break;
                case 7:
                    supermercado.crearFactura(teclado);
                    break;
                case 8:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }while (opcion != 8);


    }
}