package org.example.edadpersona;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadPersonaController {

    @GetMapping("/{day}/{month}/{year}")
    public Integer getEdadPersona(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();

        Period age = Period.between(birthDate, currentDate);

        return age.getYears();
    }
}
