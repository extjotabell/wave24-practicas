package com.spring.responseuno.demo.services;

import com.spring.responseuno.demo.entity.Persona;
import com.spring.responseuno.demo.entity.Sintoma;
import com.spring.responseuno.demo.repository.SintomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SIntomaService {

    @Autowired
    SintomaRepository sr;
    public List<Sintoma> getSintomas(){
        return sr.getSintomaList();
    }

    public int getNivelSintoma(String nombre){
        int nivel=sr.getSintomaList().stream().filter(x->x.getNombre().equals(nombre)).
                findFirst().get().getNivel_de_gravedad();
        return nivel;
    }

    public  List<Persona> getPersonasMayores(){
        return sr.getPersonaList().stream().filter(x -> x.getEdad() >= 60).toList();
    }


}
