package org.example.practica;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/")
public class EdadController {

    @GetMapping({"{dia}/{mes}/{anio}"})
    public ResponseEntity<Integer> calcularEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio) {
        LocalDate fechaDeHoy = LocalDate.now();

        LocalDate fechaDeNacimiento = LocalDate.of(anio, mes, dia);

        Integer edad = Period.between(fechaDeNacimiento, fechaDeHoy).getYears();

        return ResponseEntity.ok(edad);

    }

}
