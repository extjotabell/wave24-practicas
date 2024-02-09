package com.example.demo.services;

import com.example.demo.domain.Empleado;
import com.example.demo.elasticrepositories.EmpleadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public String save(Empleado empleado) {
        empleadoRepository.save(empleado);
        return "se agrego un empleado";
    }

    public List<Empleado> getAllByEdad(String edad){
        return empleadoRepository.findByEdadEquals(edad);
    }

    public List<Empleado> getByNombre(String nombre){
        return empleadoRepository.findByNombreContains(nombre);
    }

    public List<Empleado> getByLoQueSea(String nombre, String edad){
        return empleadoRepository.findByNombreEqualsAndEdadEquals(nombre, edad);
    }
}
