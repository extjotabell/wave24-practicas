package com.practicandoConApis.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingController {


    @GetMapping()
    public String principalPage(){
        return "Estas en la pagina principal";
    }

    @GetMapping("/hola")
    public String greetings(){
        return "Hola, como estas?";
    }

    @GetMapping("/hola/{name}/{lastname}")
    public String greetings(@PathVariable("name") String nombre,
                            @PathVariable String lastname){
        return "Hola "+ nombre +" "+ lastname +", como estas?";
    }
}
