import classes.GuardarRopa;
import classes.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Prenda> deportiva = new ArrayList<>();
        deportiva.add(new Prenda("Shorts", "Nike"));
        deportiva.add(new Prenda("Shorts", "Adidas"));
        deportiva.add(new Prenda("Camiseta", "Puma"));
        List<Prenda> elegante = new ArrayList<>();
        elegante.add(new Prenda("Traje", "Trial"));
        elegante.add(new Prenda("Pantalones", "Boss"));
        elegante.add(new Prenda("Camisa", "Tommy Hilfiger"));
        GuardarRopa tienda = new GuardarRopa();

        tienda.guardarPrendas(deportiva);
        Integer keyElegante = tienda.guardarPrendas(elegante);
        tienda.mostrarPrendas();
        System.out.println(tienda.devolverPrendas(keyElegante).toString());
    }
}
