import classes.NoPerecedero;
import classes.Perecedero;
import classes.ProbarExcepciones;

public class Main {

    public static void main(String[] args){
        ProbarExcepciones testExc = new ProbarExcepciones(2,300);
        testExc.cociente();

        Perecedero[] perecibles = {
                new Perecedero("P1", 10, 3),
                new Perecedero("P2", 20, 5),
                new Perecedero("P3", 30, 2),
                new Perecedero("P4", 40, 1),
                new Perecedero("P5", 50, 3)
        };

        NoPerecedero[] noPerecibles = {
                new NoPerecedero("NP1", 10, "legumbres"),
                new NoPerecedero("NP2", 20, "pasta"),
                new NoPerecedero("NP3", 30, "postre"),
                new NoPerecedero("NP4", 40, "ensalada"),
                new NoPerecedero("NP5", 50, "exportacion")
        };

        for(int i =0; i < perecibles.length; i++){
            perecibles[i].calcular(i+1);
            System.out.println(perecibles[i]);
        }

        for(int i =0; i < noPerecibles.length; i++){
            noPerecibles[i].calcular(i+1);
            System.out.println(noPerecibles[i]);
        }

    }
}
