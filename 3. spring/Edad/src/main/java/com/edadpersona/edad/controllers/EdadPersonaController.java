package com.edadpersona.edad.controllers;

import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
public class EdadPersonaController {

    @GetMapping("/api/edad/{dia}/{mes}/{anio}")
    public String edad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        //Obtener la fecha actual
        Date fechaActual = new Date();
        fechaActual = java.util.Calendar.getInstance().getTime();


        //Metodo actual mas sencillo
        //LocalDate date = LocalDate.of(year, month, day);
        //        return Period.between(date, LocalDate.now()).getYears();

        //Convertir a dia/mes/anio
        int diaActual = fechaActual.getDate();
        int mesActual = fechaActual.getMonth() + 1; //El mes arranca en 0
        int anioActual = fechaActual.getYear() + 1900; //El año arranca en 1900

        //Restar la fecha actual con la fecha de nacimiento
        int edad = anioActual - anio;
        //Si la persona todavia no cumplio años
        if (mesActual < mes) {
            edad--;
        }
        else if (mesActual == mes) {
            //Si el dia actual es menor al dia de nacimiento
            if (diaActual < dia) {
                edad--;
            }
        }

        //Mostrar la edad
        return "La edad es segun la fecha ingresada: " + edad;

    }
}
