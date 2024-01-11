import controller.ClienteController;
import controller.FacturaController;
import controller.ItemController;
import model.Cliente;
import view.ClienteView;
import view.FacturaView;
import view.ItemView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClienteController clienteController = new ClienteController();
        ItemController itemController = new ItemController();
        FacturaController facturaController = new FacturaController();

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(">>MENU GENERAL<<");
            System.out.println("1. Menu clientes");
            System.out.println("2. Menu facturas");
            System.out.println("3. Menu items");
            System.out.println("4. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    ClienteView clienteView = new ClienteView(clienteController);
                    break;
                case 2:
                    FacturaView facturaView = new FacturaView(facturaController);
                    break;
                case 3:
                    ItemView itemView = new ItemView(itemController);
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }

        }while (opcion !=4);
    }
}
