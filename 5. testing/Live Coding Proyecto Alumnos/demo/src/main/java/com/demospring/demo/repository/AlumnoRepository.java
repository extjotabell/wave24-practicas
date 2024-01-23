package com.demospring.demo.repository;

import com.demospring.demo.entity.Alumno;
import com.demospring.demo.exceptions.AlumnoYaExisteException;
import com.demospring.demo.exceptions.IdNoEncontradoException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AlumnoRepository {

    private List<Alumno> alumnos;

    public AlumnoRepository() {
        this.alumnos = loadDataBase();
    }

    public Alumno addAlumno(Alumno alumno){
        List<Alumno> busqueda = new ArrayList<>();
        if(alumnos.size() > 0 )
            busqueda = alumnos.stream().filter(a -> a.getDni().equals(alumno.getDni())).collect(Collectors.toList());
        if(busqueda.size() == 0 )
            alumnos.add(alumno);
        else
            throw new AlumnoYaExisteException("Un alumno con ese dni ya existe");
        return alumno;
    }

    public String deleteAlumno(String dni){
        boolean eliminado = alumnos.removeIf(alumno -> alumno.getDni().equals(dni));
        if(eliminado)
            return "Se elimino el alumno con dni: " + dni;
        else
            throw new IdNoEncontradoException("No se encontro ningun alumno con ese dni");

    }

    public Optional<Alumno> findById(String id){
        return alumnos.stream().filter(
                        alumno -> alumno.getDni().equals(id)
                )
                .findFirst();
    }
    public List<Alumno> findAll(){
        return alumnos;
    }

    private List<Alumno> loadDataBase(){
        List<Alumno> alumnojesList = null;

        File file;
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false) //nueva
                .registerModule(new JavaTimeModule()); // nueva

        TypeReference<List<Alumno>> typeRef = new TypeReference<>() {};

        try {
            file = ResourceUtils.getFile("classpath:json/people.json");
            alumnojesList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return alumnojesList;
    }
}
