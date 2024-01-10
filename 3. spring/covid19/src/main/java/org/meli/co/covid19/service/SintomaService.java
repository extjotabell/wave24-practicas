package org.meli.co.covid19.service;

import org.meli.co.covid19.model.Sintoma;

import java.util.List;

public class SintomaService {

    private List<Sintoma> sintomas;

    public SintomaService() {
        Sintoma sintoma1 = new Sintoma(1, "Fiebre", 1);
        Sintoma sintoma2 = new Sintoma(2, "Tos seca", 2);
        Sintoma sintoma3 = new Sintoma(3, "Cansancio", 3);
        Sintoma sintoma4 = new Sintoma(4, "Dificultad para respirar", 4);
        Sintoma sintoma5 = new Sintoma(5, "Dolor o presión en el pecho", 5);

        this.sintomas = List.of(sintoma1, sintoma2, sintoma3, sintoma4, sintoma5);

    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public Sintoma getSintomaByName(String name) {
        return sintomas.stream().filter(sintoma -> sintoma.getNombre().equals(name)).findFirst().orElse(null);
    }

}
