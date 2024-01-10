package com.spring.responseuno.demo.controller;

import com.spring.responseuno.demo.entity.Persona;
import com.spring.responseuno.demo.entity.Sintoma;
import com.spring.responseuno.demo.services.SIntomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SintomaController {

    @Autowired
    SIntomaService ser;
    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> getSintomas(){
        return new ResponseEntity<>(ser.getSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Integer> getNivelSintoma(@PathVariable String name){
        return new ResponseEntity<>(ser.getNivelSintoma(name),HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<Persona>> getPersonasMayores(){
        return new ResponseEntity<>(ser.getPersonasMayores(),HttpStatus.OK);
    }



}
