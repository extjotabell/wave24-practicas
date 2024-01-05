package com.exercise.rommannumeral.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GtreetingController {
    @GetMapping("saludame")
    public String greeting(){
        System.out.println("Hello world");
        return "Hello world";
    }

    @GetMapping("saludame/{nombre}")
    public String saludamePorNombre(@PathVariable String nombre){
        return "Hola " + nombre;
    }
}
