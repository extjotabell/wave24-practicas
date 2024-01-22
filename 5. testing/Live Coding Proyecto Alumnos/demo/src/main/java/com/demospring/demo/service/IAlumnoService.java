package com.demospring.demo.service;

import com.demospring.demo.dto.ListAllAlumnosDTO;
import com.demospring.demo.dto.AlumnoDTO;
import com.demospring.demo.dto.MessageDTO;

public interface IAlumnoService {

    AlumnoDTO createAlumno(AlumnoDTO alumnoDTO);

    MessageDTO deleteAlumno(String dni);

    AlumnoDTO findById(String dni);

    ListAllAlumnosDTO findAll();
}
