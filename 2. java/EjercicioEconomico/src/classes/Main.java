package classes;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("12335345-1", "N1", "A1");
        Cliente cliente2 = new Cliente("12543253-2", "N2", "A2");
        Cliente cliente3 = new Cliente("74765754-3", "N3", "A3");

        List<Cliente> listaCliente = new ArrayList<Cliente>();
        listaCliente.add(cliente1);
        listaCliente.add(cliente2);
        listaCliente.add(cliente3);

        for (Cliente cliente: listaCliente ){
            System.out.println(cliente);
        }

        listaCliente.remove(cliente3);
        for (Cliente cliente: listaCliente ){
            System.out.println(cliente);
        }


        System.out.println("Ingrese un número de dni de cliente: ");
        Scanner scanner = new Scanner(System.in);
        String dniBuscado = scanner.nextLine();
        for (Cliente cliente : listaCliente){
            if (cliente.getDni().equals(dniBuscado)){
                System.out.println(cliente);
            }
        }

    }
}
