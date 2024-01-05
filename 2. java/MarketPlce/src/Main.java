import classes.Cliente;
import classes.Factura;
import classes.Item;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Cliente> listaClientes;

        List<Item> itemList;

        Cliente cliente1 = new Cliente("1001032661", "Yoiber", "Beitar");
        Cliente cliente2 = new Cliente("1450029344", "Andres", "Garcia");
        Cliente cliente3 = new Cliente("103488764", "Carlos", "Melendez");
        listaClientes = new ArrayList<>(Arrays.asList(cliente1, cliente2, cliente3));


        Item item1 = new Item(23567, "Crema Colgate", 3, 2.700);
        Item item2 = new Item(32479, "Jabon Liquido", 2, 3.200);
        Item item3 = new Item(44332, "Jamon", 1, 5.000);
        Item item4 = new Item(22174, "Escoba", 1, 6.000);
        Item item5 = new Item(90606, "Jabon de baño", 4, 2.800);
        itemList = new ArrayList<>(Arrays.asList(item1, item2, item3, item4, item5));

        Factura factura = new Factura();



        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
//
//        listaClientes.remove(1);
//        System.out.println("Clientes con menos 1");
//        for (Cliente cliente : listaClientes) {
//            System.out.println(cliente);
//        }

//        Scanner DNI = new Scanner(System.in);
//        System.out.println("Ingrese el DNI  buscar");
//        String dniABuscar = DNI.next();
//        String notFoundMessage = "E";
//
//        var resultado = listaClientes.stream()
//                .filter(cliente -> dniABuscar.equals(cliente.getDni()))
//                .findAny()
//                .orElse(null);

//        if(resultado != null) System.out.println(resultado);
//        else System.out.println("No se encontro el dato solicitado");




    }
}