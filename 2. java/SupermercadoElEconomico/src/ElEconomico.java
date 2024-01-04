import clases.Cliente;
import clases.Supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElEconomico {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        List<Cliente> listaClientes = new ArrayList<>();

        Cliente cliente1 = new Cliente(40392862, "Maria", "Perez");
        Cliente cliente2 = new Cliente(35685280, "Romina", "Gonzalez");
        Cliente cliente3 = new Cliente(17654234, "Marcos", "Rodriguez");

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        Supermercado supermercado = new Supermercado(listaClientes);

        int opcion = 0;
        do{
            //Menu
            System.out.println("Menu: ");
            System.out.println("1- Visualizar la lista de clientes con sus datos");
            System.out.println("2- Eliminar un cliente");
            System.out.println("3- Buscar cliente");
            System.out.println("4- Crear nueva factura");
            System.out.println("5- Salir");
            System.out.println("Ingrese su opcion: ");

            opcion = teclado.nextInt();

            switch (opcion){
                case 1:
                    List<Cliente> clientes = supermercado.listar();
                    if (clientes.isEmpty()) {
                        System.out.println("No se encontró ningún cliente.");
                    } else {
                        for (Cliente cliente : clientes) {
                            System.out.println(cliente);
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nIngrese el DNI del cliente que desea eliminar:");
                    int dniEliminar = teclado.nextInt();
                    supermercado.baja(dniEliminar);

                    break;
                case 3:
                    System.out.println("\nIngrese el DNI del cliente que desea buscar:");
                    int dniBuscar = teclado.nextInt();
                    supermercado.buscar(dniBuscar);
                        break;
                case 4:
                    supermercado.crearFactura(teclado);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }while (opcion != 5);


    }
}