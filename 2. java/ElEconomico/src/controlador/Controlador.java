package controlador;

import modelo.Cliente;
import modelo.Factura;
import modelo.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controlador {

    public Controlador () {

       Scanner sc = new Scanner(System.in);

       List<Cliente> clientes = new ArrayList<>();

       List<Factura> facturas = new ArrayList<>();

       List<Item> items = new ArrayList<>();

       boolean salir = false;

       while (!salir){
           System.out.println("1. CRUD CLIENTES");

           System.out.println("2. CRUD FACTURAS");

           System.out.println("3. CRUD ITEMS");

           System.out.println("4. Salir");

           System.out.println("Introduce una opción: ");

           int opcion = sc.nextInt();

           sc.nextLine();
           switch (opcion) {
               case 1:
                   ClienteCRUD clienteCRUD = new ClienteCRUD(clientes);
                   clientes = clienteCRUD.getClientes();;
                   break;
               case 2:
                   FacturaCRUD facturaCRUD = new FacturaCRUD(facturas, items, clientes);
                     facturas = facturaCRUD.getFacturas();
                   break;
               case 3:
                   ItemCRUD itemCRUD = new ItemCRUD(items);
                     items = itemCRUD.getItems();
                   break;
               case 4:
                   salir = true;
                   break;
               default:
                   System.out.println("Opción no válida");
                   break;
           }
       }


    }


}
