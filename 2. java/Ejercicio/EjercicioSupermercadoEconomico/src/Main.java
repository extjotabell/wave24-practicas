import Repository.ClienteImp;
import Repository.FacturaImp;
import Repository.ItemImp;
import classes.Cliente;
import classes.Factura;
import classes.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClienteImp clienteImp = new ClienteImp();
        ItemImp itemImp = new ItemImp();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("--- MENU ---");
            System.out.println("1. Cliente");
            System.out.println("2. Item");
            System.out.println("3. Factura");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    accionesCliente(clienteImp);
                    break;
                case 2:
                    accionesItem(itemImp);
                    break;
                case 3:
                    accionesFactura(clienteImp, itemImp);
                    break;
            }
        }while (opcion != 4);
    }

    private static void accionesCliente(ClienteImp clienteImp) {
        //ClienteImp clienteImp = new ClienteImp();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1. Crear clientes");
            System.out.println("2. Mostrar clientes");
            System.out.println("3. Buscar cliente por DNI");
            System.out.println("4. Eliminar cliente por DNI");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    //crear lista de clientes
                    Cliente cliente1 = new Cliente(123L, "John", "Doe");
                    Cliente cliente2 = new Cliente(456L, "Jane", "Doe");
                    Cliente cliente3 = new Cliente(789L, "Maria", "Carson");

                    //guardar clientes
                    clienteImp.guardar(cliente1);
                    clienteImp.guardar(cliente2);
                    clienteImp.guardar(cliente3);
                    break;
                case 2:
                    //mostrar clientes
                    clienteImp.mostrar();
                    break;
                case 3:
                    //buscar clientes por DNI
                    System.out.println("--- Encontrar cliente por DNI ---");
                    System.out.println("Ingrese el DNI del cliente: ");
                    Long dni = scanner.nextLong();
                    var clienteEncontrado = clienteImp.buscar(dni).orElse(null);
                    System.out.println(clienteEncontrado);
                    break;
                case 4:
                    //eliminar clientes por DNI
                    System.out.println("--- Eliminar cliente por DNI ---");
                    System.out.println("Ingrese el DNI del cliente a eliminar: ");
                    Long dniClienteEliminat = scanner.nextLong();
                    clienteImp.eliminar(dniClienteEliminat);
                    break;
            }
        }while (opcion != 5);
    }
    private static void accionesItem(ItemImp itemImp) {
        //ItemImp itemImp = new ItemImp();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1. Crear items");
            System.out.println("2. Mostrar items");
            System.out.println("3. Buscar item por Codigo");
            System.out.println("4. Eliminar item por Codigo");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    //crear items
                    Item item1 = new Item(1L, "Item 1", 2, 10.0f);
                    Item item2 = new Item(2L, "Item 2", 4, 20.0f);
                    Item item3 = new Item(3L, "Item 3", 6, 30.0f);

                    itemImp.guardar(item1);
                    itemImp.guardar(item2);
                    itemImp.guardar(item3);
                    break;
                case 2:
                    //mostrar clientes
                    itemImp.mostrar();
                    break;
                case 3:
                    //buscar item por código
                    System.out.println("--- Encontrar item por código ---");
                    System.out.println("Ingrese el código del item: ");
                    Long codigo = scanner.nextLong();
                    var item = itemImp.buscar(codigo).orElse(null);
                    System.out.println(item);
                    break;
                case 4:
                    //eliminar item por codigo
                    System.out.println("--- Eliminar item por código ---");
                    System.out.println("Ingrese el código del item a eliminar: ");
                    Long codigoItemEliminar = scanner.nextLong();
                    itemImp.eliminar(codigoItemEliminar);
                    break;
            }
        }while (opcion != 5);
    }
    private static void accionesFactura(ClienteImp clienteImp, ItemImp itemImp) {
        Scanner scanner = new Scanner(System.in);
        //ClienteImp clienteImp = new ClienteImp();
        //ItemImp itemImp = new ItemImp();
        FacturaImp facturaImp = new FacturaImp();
        System.out.println("--- Crear facturas ---");
        System.out.println("--- Encontrar cliente para asociar ---");
        System.out.println("Ingrese el DNI del cliente: ");
        Long dni = scanner.nextLong();
        var cliente = clienteImp.buscar(dni).orElse(null);
        float totalCostosItem = 0f;
        for (Item item : itemImp.consultarTodos()) {
            totalCostosItem +=  (item.getCostoUnitario() * item.getCantidadComprada());
        }
        facturaImp.guardar(new Factura(1L, cliente, itemImp.consultarTodos(), totalCostosItem));
        System.out.println("--- Consultar facturas ---");
        facturaImp.mostrar();
    }
}