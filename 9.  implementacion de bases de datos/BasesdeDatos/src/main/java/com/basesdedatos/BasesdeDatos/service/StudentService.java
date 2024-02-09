package com.basesdedatos.BasesdeDatos.service;

import com.basesdedatos.BasesdeDatos.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;



}

