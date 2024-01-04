package ejercicio1;

import ejercicio1.classes.Prototipo;
import ejercicio1.classes.Serie;

public class Main {
    public static void main(String[] args) {
        Serie serie = new Serie(3, 2);
        Number value = serie.nextValue();
        Number value2 = serie.nextValue();
        Number value3 = serie.nextValue();
        Number value4 = serie.nextValue();

        System.out.println(value.intValue());
        System.out.println(value2.intValue());
        System.out.println(value3.intValue());
        System.out.println(value4.intValue());

    }
}