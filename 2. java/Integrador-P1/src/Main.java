import classes.Cliente;
import classes.Factura;
import classes.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("1","Pedro","Perez"));
        clientes.add(new Cliente("2","Juan","Sanchez"));
        clientes.add(new Cliente("3","Andres","Ramirez"));

        System.out.println("Todos los clientes: ");
        clientes.forEach(System.out::println);
        clientes.remove(2);
        System.out.println("Los clientes luego de remover a uno: ");
        clientes.forEach(System.out::println);

        List<Factura> facturas = new ArrayList<>();
        List<Item> items = new ArrayList<>();
        items.add(new Item(5251L,"Mayonesa",2,635D));
        items.add(new Item(5252L,"Queso",5,1299D));
        items.add(new Item(5253L,"Arroz",3,800D));
        items.add(new Item(5254L,"Tomate",14,345D));
        Factura factura = new Factura(15L,clientes.get(0),items);
        factura.calcularTotalCompra();
        System.out.println("Factura: "+factura);

        //Busqueda de cliente by dni
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar el dni de un cliente: ");
        String dni = scanner.nextLine();

        Optional<Cliente> optionalCliente = clientes.stream().filter(x -> x.getDni().equals(dni)).findFirst();
        if(optionalCliente.isPresent()){
            System.out.println(optionalCliente.get().toString());
        }else{
            System.out.println("El dni no está registrado en ningún cliente.");
        }*/

    }
}
