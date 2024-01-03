import classes.Curriculum;
import classes.Informe;
import classes.LibroPDF;
import classes.interfaces.Imprimible;
import java.util.ArrayList;

public class Main {

    //Metodo estatico para imprimir
    public static void imprimir(Imprimible imprimible) {
        imprimible.imprimir();
    }

    public static void main (String[] args){
        //Lista de habilidades para el CV
        ArrayList<String>  habilidadesCv= new ArrayList<String >();
        habilidadesCv.add("habilidad1");
        habilidadesCv.add("habilidad2");
        habilidadesCv.add("habilidad3");

        Curriculum cv = new Curriculum("Nombre1","Apellido1","123456789",habilidadesCv);
        Informe informe = new Informe("Texto de prueba de informe",1,"autor1","revisor1");
        LibroPDF libro = new LibroPDF(2,"autor2", "titulo1","genero1");

        imprimir(cv);
        imprimir(informe);
        imprimir(libro);
    }
}
