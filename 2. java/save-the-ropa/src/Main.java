import classes.GuardaRopa;
import classes.Prenda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda poleraRelaxed = new Prenda("h&m", "relaxed fit");
        Prenda poleraLong = new Prenda("h&m", "long fit");
        Prenda poleraRegular = new Prenda("h&m", "regular fit");
        Prenda poleraOversize = new Prenda("h&m", "oversize fit");
        Prenda poleraSlim = new Prenda("h&m", "slim fit");
        Prenda pantalon = new Prenda("h&m", "Jogger");
        List<Prenda> prendas = new ArrayList<>(Arrays.asList(poleraSlim, poleraRelaxed, poleraLong, poleraOversize));
        List<Prenda> prendas2 = new ArrayList<>(Arrays.asList(poleraSlim, pantalon, poleraRegular));
        List<Prenda> prendas3 = new ArrayList<>(Arrays.asList(poleraRelaxed, pantalon, poleraLong));

        GuardaRopa guardaRopa = new GuardaRopa();

        Integer lastKey = guardaRopa.guardarPrendas(prendas);
        System.out.println("ultimo id guardado: "+ lastKey);
        Integer lastKey2 = guardaRopa.guardarPrendas(prendas2);
        System.out.println("ultimo id guardado: "+ lastKey2);
        Integer lastKey3 = guardaRopa.guardarPrendas(prendas3);
        System.out.println("ultimo id guardado: "+ lastKey3);

        guardaRopa.mostrarPrendas();

        List<Prenda> prendasFinded = guardaRopa.devolverPrendas(1);
        System.out.println("Prendas finded: " + prendasFinded);
    }
}
