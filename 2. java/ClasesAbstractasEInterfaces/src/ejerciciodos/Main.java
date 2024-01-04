package ejerciciodos;

import ejerciciodos.classes.Curriculum;
import ejerciciodos.classes.Informe;
import ejerciciodos.classes.LibroPDF;
import ejerciciodos.classes.Printer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Curriculum cv = new Curriculum("Joaquín", new String[]{"habilidades"});
        Informe informe = new Informe("Texto del informe", 1, "Autor", "Revisor");
        LibroPDF libro = new LibroPDF(1,"Autor", "Titulo del libro", "Drama");

        Printer impresora = new Printer();
        impresora.print(cv);
        impresora.print(informe);
        impresora.print(libro);
    }
}
