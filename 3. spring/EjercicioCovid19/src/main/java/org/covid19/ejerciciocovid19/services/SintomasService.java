package org.covid19.ejerciciocovid19.services;

import org.covid19.ejerciciocovid19.models.Sintomas;

import java.util.List;

public class SintomasService {
    Sintomas sintoma = new Sintomas(1, "tos", 1);
    Sintomas sintoma2 = new Sintomas(2, "gripa", 2);
    Sintomas sintoma3 = new Sintomas(3, "fiebre", 3);
    List<Sintomas> sintomasList = List.of(sintoma, sintoma2, sintoma3);

    public List<Sintomas> obtenerSintomas() {
        return sintomasList;
    }
    public Sintomas obtenerSintomaPorNombre(String name) {
        for (Sintomas sintoma : sintomasList) {
            if (sintoma.getNombre().equals(name)) {
                return sintoma;
            }
        }
        return null;
    }
}
