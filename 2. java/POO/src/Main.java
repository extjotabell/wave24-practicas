import classes.Perecedero;
import classes.Persona;
import classes.Producto;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Persona persona = new Persona();
//        Persona persona1 = new Persona("Yoiber", 22,  "1001032661");
//        Persona persona2 = new Persona("Yoiber", 22,  "1001032661", 54.65, 1.66);
        // Persona persona3 = new Persona("Yoiber", 22);

        Producto producto = new Producto("Queso", 23000);
        System.out.println(producto.calcular(2));

        Perecedero perecedero1 = new Perecedero("Queso");
        Perecedero perecedero2 = new Perecedero();
        Perecedero perecedero3 = new Perecedero();
    }
}