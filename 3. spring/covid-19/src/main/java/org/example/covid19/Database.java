package org.example.covid19;

import org.example.covid19.model.Persona;
import org.example.covid19.model.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private final Sintoma tos = new Sintoma("tos", "Tos", 1);
    private final Sintoma fiebre = new Sintoma("fiebre", "Fiebre", 2);
    private final Sintoma dolorDeCabeza = new Sintoma("dolorDeCabeza", "Dolor de cabeza", 3);
    private final Sintoma dolorDeGarganta = new Sintoma("dolorDeGarganta", "Dolor de garganta", 4);
    private final Sintoma dificultadRespiratoria = new Sintoma("dificultadRespiratoria", "Dificultad respiratoria", 5);

    private List<Sintoma> sintomas = new ArrayList<>() {{
        add(tos);
        add(fiebre);
        add(dolorDeCabeza);
        add(dolorDeGarganta);
        add(dificultadRespiratoria);
    }};

    private final List<Persona> personas = new ArrayList<>() {{
        add(new Persona(1, "Juan", "Perez", 30, new ArrayList<>() {{
            add(dolorDeCabeza);
            add(dolorDeGarganta);
        }}));
        add(new Persona(2, "Maria", "Gonzalez", 40, new ArrayList<>() {{
            add(dolorDeCabeza);
        }}));
        add(new Persona(3, "Pedro", "Gomez", 65, new ArrayList<>()));
        add(new Persona(4, "Jose", "Gimenez", 60, new ArrayList<>() {{
            add(dolorDeCabeza);
            add(dolorDeGarganta);
        }}));
        add(new Persona(5, "Ana", "Rodriguez", 70, new ArrayList<>() {{
            add(fiebre);
            add(tos);
        }}));
    }};

    public static List<Persona> getPersonas() {
        return new Database().personas;
    }

    public static List<Sintoma> getSintomas() {
        return new Database().sintomas;
    }

}
