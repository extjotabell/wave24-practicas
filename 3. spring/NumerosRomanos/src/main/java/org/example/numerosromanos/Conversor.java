package org.example.numerosromanos;

import jdk.jfr.Registered;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Conversor {

    @GetMapping ("/{numero}")
    public String conversor(@PathVariable int numero) {
        if(numero == 1) {
            return "I";
        } else if (numero == 2) {
            return "II";
        } else {
            return "III";
        }
    }
}
