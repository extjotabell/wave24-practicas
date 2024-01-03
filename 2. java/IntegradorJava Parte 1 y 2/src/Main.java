import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente c1= new Cliente( 5790132,  "Juan", "Zunino") ;
        Cliente c2= new Cliente( 6743652,  "Jose", "Rodriguez") ;
        Cliente c3= new Cliente( 4532543,  "Sergio", "Koltos") ;

        ArrayList<Cliente> lisCli = new ArrayList<>();
        lisCli.add(c1);
        lisCli.add(c2);
        lisCli.add(c3);
        for (int i = 0; i < lisCli.size(); i++) {
            System.out.println(lisCli.get(i));
        }

        lisCli.remove(c2);
        System.out.println("######################");
        for (int i = 0; i < lisCli.size(); i++) {
            System.out.println(lisCli.get(i));
        }
        System.out.println("######################");
        System.out.println(" ingrese un dni: ");
        Scanner in = new Scanner(System.in);

        int id = in.nextInt();

        boolean found = false;
        Cliente cli = null;
        for (int i = 0; i < lisCli.size(); i++) {
            if (lisCli.get(i).getDni()==id){
                System.out.println("El cliente con dni " + id +" tiene datos:");
                System.out.println(lisCli.get(i));
                cli = lisCli.get(i);
                found=true;
            }
        }
        if (!found){
            System.out.println("No se encontro el cliente con dni " + id + " asi que se creara ");
            System.out.println(" ingrese un dni: ");
            int dni = in.nextInt();
            System.out.println(" ingrese un nombre: ");
            String nombre = in.next();
            System.out.println(" ingrese un apellido: ");
            String apellido = in.next();
            cli = new Cliente(dni,nombre,apellido);
            lisCli.add(cli);
        }
        ArrayList<Producto> lisProds = new ArrayList<Producto>();
        Producto p = new Producto(123,"Manzana", 3, 10);
        Producto p1 = new Producto(321,"Carne", 2, 50);
        Producto p2 = new Producto(123,"Helado", 1, 25);
        lisProds.add(p);
        lisProds.add(p1);
        lisProds.add(p2);
        int total = 0;
        for (int i = 0; i < lisProds.size(); i++) {
            total= total +(lisProds.get(i).getCantidad()*lisProds.get(i).getCostoUnitario());
        }

        Factura f = new Factura(cli,lisProds,total);

        System.out.println("#######################");
        System.out.println("la factura: ");
        System.out.println("Cliente: "+f.getCliente());
        System.out.println("Lista de Productos: ");

        for (int i = 0; i < f.getListaProductos().size(); i++) {
            System.out.println(f.getListaProductos().get(i));
        }
        System.out.println("total: "+f.getTotal());


    }
}