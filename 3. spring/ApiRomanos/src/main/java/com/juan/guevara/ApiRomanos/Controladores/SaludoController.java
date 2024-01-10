package com.juan.guevara.ApiRomanos.Controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/controlador")
@RestController
public class SaludoController {

    @GetMapping("/saludar")
    public String saludo(){
        return "Hola mundo";
    }
}
