package controlador;

import modelo.Item;

import java.util.List;
import java.util.Scanner;

public class ItemCRUD {

    List<Item> items;

    public ItemCRUD(List<Item> items) {
        this.items = items;
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("1. Crear item");
            System.out.println("2. Leer item");
            System.out.println("3. Actualizar item");
            System.out.println("4. Borrar item");
            System.out.println("5. Salir");
            System.out.println("Introduce una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    crearItem();
                    break;
                case 2:
                    System.out.println("Introduce el dni del cliente a buscar: ");
                    String dni = sc.nextLine();
                    leerItem(dni);
                    break;
                case 3:
                    actualizarItem();
                    break;
                case 4:
                    borrarItem();
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

    public void crearItem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el codigo del item: ");
        int codigo = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce el nombre del item: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce el precio del item: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.println("Introduce la cantidad del item: ");
        int cantidad = sc.nextInt();

        items.add(new Item(codigo, nombre, precio, cantidad));
    }

    public void leerItem(String dni) {

    }

    public void actualizarItem() {

    }

    public void borrarItem() {

    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
