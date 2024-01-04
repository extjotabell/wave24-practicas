import classes.Cliente;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Cliente> listaClientes = new ArrayList<>();

        Cliente cliente1 = new Cliente("1001032661", "Yoiber", "Beitar");
        Cliente cliente2 = new Cliente("1450029344", "Andres", "Garcia");
        Cliente cliente3 = new Cliente("103488764", "Carlos", "Melendez");

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }

        listaClientes.remove(1);
        System.out.println("Clientes con menos 1");
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }

        Scanner DNI = new Scanner(System.in);
        System.out.println("Ingrese el DNI  buscar");
        String dniABuscar = DNI.next();
        String notFoundMessage = "E";

        var resultado = listaClientes.stream()
                .filter(cliente -> dniABuscar.equals(cliente.getDni()))
                .findAny()
                .orElse(null);

        if(resultado != null) System.out.println(resultado);
        else System.out.println("No se encontró el dato solicitadó");


    }
}