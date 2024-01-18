package org.example.demospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping()
    public String principalPage(){
        return "Pagina principal";
    }

    @GetMapping("/hola")
    public String greetings(){
        return "Hola, como estas?";
    }
}

