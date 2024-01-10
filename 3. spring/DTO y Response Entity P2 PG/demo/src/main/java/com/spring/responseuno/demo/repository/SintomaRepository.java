package com.spring.responseuno.demo.repository;

import com.spring.responseuno.demo.entity.Persona;
import com.spring.responseuno.demo.entity.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class SintomaRepository {

    private List<Sintoma> sintomaList;
    private List<Persona> personaList;

    public SintomaRepository() {
        this.sintomaList = new ArrayList<>();
        this.personaList = new ArrayList<>();

        Sintoma sintoma1 = new Sintoma(101, "Dolor de cabeza", 3);
        Sintoma sintoma2 = new Sintoma(102, "Fiebre alta", 4);
        Sintoma sintoma3 = new Sintoma(103, "Dolor de garganta", 2);
        Sintoma sintoma4 = new Sintoma(104, "Fatiga", 3);
        Sintoma sintoma5 = new Sintoma(105, "Náuseas", 2);

        sintomaList.add(sintoma1);
        sintomaList.add(sintoma2);
        sintomaList.add(sintoma3);
        sintomaList.add(sintoma4);
        sintomaList.add(sintoma5);

        Persona persona1 = new Persona(1, "Juan", "Perez", 35);
        Persona persona2 = new Persona(2, "Maria", "Gomez", 45);
        Persona persona3 = new Persona(3, "Carlos", "Rodriguez", 70);
        Persona persona4 = new Persona(4, "Ana", "Lopez", 55);
        Persona persona5 = new Persona(5, "Pedro", "Martinez", 65);

        personaList.add(persona1);
        personaList.add(persona2);
        personaList.add(persona3);
        personaList.add(persona4);
        personaList.add(persona5);
    }
}
