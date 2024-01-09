package com.spring.responseuno.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/sports")
public class DeporteRestController {


    @GetMapping("/")
    public ResponseEntity<List<Deporte>> getSports(){
        return new ResponseEntity<> (Sistema.listSport, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getSpecificSport(@PathVariable String name){
        Optional<Deporte> deporte= Sistema.listSport.stream().filter(x -> x.getNombre().equals(name)).findFirst();
        if(deporte.isPresent()){
            return new ResponseEntity<> (deporte, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<> ("No existe el deporte", HttpStatus.NOT_FOUND);
        }
    }

}
