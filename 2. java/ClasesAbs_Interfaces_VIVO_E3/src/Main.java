import classes.Animal;
import classes.Gato;
import classes.Perro;
import classes.Vaca;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        System.out.println("Perro");
        perro.emitirSonido();

        Gato gato = new Gato();
        System.out.println("Gato");
        gato.emitirSonido();

        Vaca vaca = new Vaca();
        System.out.println("Vaca");
        vaca.emitirSonido();

        Animal.comerAnimal(perro);
        Animal.comerAnimal(gato);
        Animal.comerAnimal(vaca);

    }
}