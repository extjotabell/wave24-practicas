import classes.NoPerecedero;
import classes.Perecedero;
import classes.Producto;

public class Distribuidora {
    public static void main(String[] args){
        Producto[] productos = {new Perecedero("Pescado",9000,2),
                new NoPerecedero("Fideos",800,"Largos")};
        double total = 0;
        for(int i = 0; i< productos.length; i++){
            total += productos[i].calcular(5);
        }

        System.out.println("El total es: "+total);
    }
}
