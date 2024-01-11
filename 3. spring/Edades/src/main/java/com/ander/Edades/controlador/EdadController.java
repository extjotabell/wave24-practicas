package com.ander.Edades.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/age")
public class EdadController {

    @GetMapping()
    public String saludo() {
        return "Hola";
    }

    @GetMapping("/{dia}/{mes}/{anio}")
    public Integer edad(@PathVariable int dia, @PathVariable int mes , @PathVariable int  anio) {
        try{
            LocalDate date = LocalDate.of(anio, mes, dia);
            return  Period.between(date, LocalDate.now()).getYears();
        }catch(Exception e){return 0;}

    }

}
