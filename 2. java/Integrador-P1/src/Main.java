import classes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    static ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
    static FacturaRepositorio facturaRepositorio = new FacturaRepositorio();
    public static void main(String[] args) {
        creacionClientes();

        creacionFactura();

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
    public static void creacionFactura(){
        List<Item> items = creacionItems();
        facturaRepositorio.save(new Factura(15L,clienteRepositorio.getById(2L),items));
        Factura factura = facturaRepositorio.getById(15L);
        Double totalFactura = facturaRepositorio.calcularTotalCompra(factura);
        factura.setTotalCompra(totalFactura);
        System.out.println("Factura: "+factura);
    }
    public static List<Item> creacionItems(){
        List<Item> items = new ArrayList<>();
        items.add(new Item(5251L,"Mayonesa",2,635D));
        items.add(new Item(5252L,"Queso",5,1299D));
        items.add(new Item(5253L,"Arroz",3,800D));
        items.add(new Item(5254L,"Tomate",14,345D));
        return items;
    }
    public static void creacionClientes(){
        clienteRepositorio.save(new Cliente(1L,"Pedro","Perez"));
        clienteRepositorio.save(new Cliente(2L,"Juan","Sanchez"));
        clienteRepositorio.save(new Cliente(3L,"Andres","Ramirez"));

        System.out.println("Todos los clientes: ");
        System.out.println(clienteRepositorio.list());
        clienteRepositorio.delete(clienteRepositorio.getById(1L));
        System.out.println("Los clientes luego de remover a uno: ");
        System.out.println(clienteRepositorio.list());
    }
}
