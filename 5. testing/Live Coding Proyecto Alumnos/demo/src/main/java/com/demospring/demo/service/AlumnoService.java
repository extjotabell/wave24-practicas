package com.demospring.demo.service;

import com.demospring.demo.dto.ListAllAlumnosDTO;
import com.demospring.demo.dto.MateriaDTO;
import com.demospring.demo.dto.AlumnoDTO;
import com.demospring.demo.dto.MessageDTO;
import com.demospring.demo.entity.Alumno;
import com.demospring.demo.entity.Materia;
import com.demospring.demo.exceptions.ListaVaciaException;
import com.demospring.demo.exceptions.IdNoEncontradoException;
import com.demospring.demo.repository.AlumnoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnoService implements IAlumnoService {

    @Autowired
    AlumnoRepository alumnoRepository;

    @Override
    public AlumnoDTO createAlumno(AlumnoDTO alumnoDTO) {

        Alumno alumno = convertToEntity(alumnoDTO);

        Alumno alumnoAgregado = alumnoRepository.addAlumno(alumno);

        return convertToDTO(alumnoAgregado);
    }

    @Override
    public MessageDTO deleteAlumno(String dni) {
        String message = alumnoRepository.deleteAlumno(dni);
        return new MessageDTO(message);
    }

    @Override
    public AlumnoDTO findById(String dni) {
        Alumno alumnoFound = alumnoRepository.findById(dni)
                .orElseThrow(
                        () -> {
                            throw new IdNoEncontradoException("No se encontro alumno con dni: " + dni);
                        }
                );

        return convertToDTO(alumnoFound);
    }

    @Override
    public ListAllAlumnosDTO findAll() {
        List<Alumno> listAlumno = alumnoRepository.findAll();

        if (listAlumno.isEmpty()) 
            throw new ListaVaciaException("No se encontro nada en la lista de: ", "Alumnos");

        var listDTOs = listAlumno.stream().map(
                this::convertToDTO
        ).collect(Collectors.toList());

        return new ListAllAlumnosDTO(listDTOs);

    }

    private Alumno convertToEntity(AlumnoDTO alumnoDTO){
        return new Alumno(
                alumnoDTO.dni(),
                alumnoDTO.name(),
                alumnoDTO.birthDate(),
                alumnoDTO.age(),
                alumnoDTO.materiasList().stream().map(
                        m -> new Materia(
                                m.id(),
                                m.name(),
                                m.promedio()
                        )).collect(Collectors.toList())
        );
    }

    private AlumnoDTO convertToDTO(Alumno alumno){
        return new AlumnoDTO(
                alumno.getDni(),
                alumno.getName(),
                alumno.getBirthDate(),
                alumno.getAge(),
                alumno.getMateriasList().stream().map(
                        m -> new MateriaDTO(
                                m.getId(),
                                m.getName(),
                                m.getPromedio()
                        )).collect(Collectors.toList())
        );
    }
}
