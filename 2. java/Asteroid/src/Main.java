import clases.FlotaDeNaves;
import clases.Juego;
import clases.NaveSimple;
import interfaces.Participante;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        NaveSimple nave1 = new NaveSimple("Nave1", 0, 0);
        NaveSimple nave2 = new NaveSimple("Nave2", 1, 1);
        NaveSimple nave3 = new NaveSimple("Nave3", -1, -1);

        FlotaDeNaves flota1 = new FlotaDeNaves("Flota1");
        flota1.agregarNave(nave1);
        flota1.agregarNave(nave2);

        FlotaDeNaves flota2 = new FlotaDeNaves("Flota2");
        flota2.agregarNave(nave3);

        List<Participante> participantes = new ArrayList<>();
        participantes.add(nave1);
        participantes.add(nave2);
        participantes.add(nave3);
        participantes.add(flota1);
        participantes.add(flota2);

        Juego juego = new Juego(participantes);

        int[][] coordenadas = {{1, 1}, {0, 0}, {-1, -1}, {2, 2}, {-2, -2}};

        juego.jugar(coordenadas);
    }
}