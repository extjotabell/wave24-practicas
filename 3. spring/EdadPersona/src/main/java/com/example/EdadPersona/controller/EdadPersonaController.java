package com.example.EdadPersona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class EdadPersonaController {
    @GetMapping("/fecha")
    public String getEdadPersona(@RequestParam("dia") String dia, @RequestParam("mes") String mes, @RequestParam("anio") String anio) {
        return "La edad de la persona es: " + calcularEdad(dia, mes, anio);
    }

    public int calcularEdad(String dia, String mes, String anio) {
        int edad = 0;
        int diaActual = 0;
        int mesActual = 0;
        int anioActual = 0;
        int diaNacimiento = Integer.parseInt(dia);
        int mesNacimiento = Integer.parseInt(mes);
        int anioNacimiento = Integer.parseInt(anio);

        Date fecha = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaActual = sdf.format(fecha);
        String[] fechaActualArray = fechaActual.split("/");
        diaActual = Integer.parseInt(fechaActualArray[0]);
        mesActual = Integer.parseInt(fechaActualArray[1]);
        anioActual = Integer.parseInt(fechaActualArray[2]);

        edad = anioActual - anioNacimiento;
        if (mesActual < mesNacimiento) {
            edad--;
        } else if (mesActual == mesNacimiento) {
            if (diaActual < diaNacimiento) {
                edad--;
            }
        }

        return edad;
    }

}
