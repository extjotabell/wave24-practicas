import classes.Curriculum;
import classes.Informe;
import classes.LibroPdf;
import interfaces.Imprimible;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Enzo","Comba"
                ,Arrays.asList("Programador de java", "Programador de Backend"));
        LibroPdf libroPdf = new LibroPdf(5,"Enzo","Datitos","Analisis de datos");
        Informe informe = new Informe("Prototipo de informe",1,"Enzo","Enzo");

        Imprimible.imprimirDocumento(curriculum);
        Imprimible.imprimirDocumento(libroPdf);
        Imprimible.imprimirDocumento(informe);
    }
}
