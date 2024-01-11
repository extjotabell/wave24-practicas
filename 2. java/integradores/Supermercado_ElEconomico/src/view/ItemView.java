package view;

import controller.ItemController;
import model.Item;

import java.util.Scanner;

public class ItemView {

    private ItemController itemController;

    public ItemView(ItemController itemController) {
        this.itemController = itemController;
        generarMenu();
    }

    public void generarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(">>MENU ITEMS<<");
            System.out.println("1. Crear item");
            System.out.println("2. Mostrar items");
            System.out.println("3. Buscar por codigo ");
            System.out.println("4. Eliminar item por codigo");
            System.out.println("5. Salir");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println(">>CREANDO ITEMS<<");
                    Item item1 = new Item(1, "item 1", 5, 2000);
                    Item item2 = new Item(2, "item 2", 10, 4000);
                    Item item3 = new Item(3, "item 3", 15, 6000);

                    itemController.guardar(item1);
                    itemController.guardar(item2);
                    itemController.guardar(item3);
                    break;
                case 2:
                    System.out.println(">>MOSTRAR ITEM<<");
                    itemController.mostrar();
                    break;
                case 3:
                    System.out.println(">>BUSCAR ITEM<<");
                    System.out.println("Ingrese codigo del item: ");
                    int codigoBuscado = sc.nextInt();
                    var itemBuscado = itemController.buscar(codigoBuscado).orElse(null);
                    System.out.println(itemBuscado);
                    break;
                case 4:
                    System.out.println(">>ELIMINAR ITEM<<");
                    System.out.println("Ingrese codigo del item: ");
                    int codigoParaEliminar = sc.nextInt();
                    itemController.eliminar(codigoParaEliminar);
                    break;
            }
        }while (opcion !=5);
    }
}
