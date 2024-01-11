package com.spring.Morse.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/morse")
public class MorseController {

    Map<String, String> mapa = new HashMap<>();

    public MorseController() {

        mapa.put(".-", "A");
        mapa.put("-...", "B");
        mapa.put("-.-.", "C");
        mapa.put("-..", "D");
        mapa.put(".", "E");
        mapa.put("..-.", "F");
        mapa.put("--.", "G");
        mapa.put("....", "H");
        mapa.put("..", "I");
        mapa.put(".---", "J");
        mapa.put("-.-", "K");
        mapa.put(".-..", "L");
        mapa.put("--", "M");
        mapa.put("-.", "N");
        mapa.put("---", "O");
        mapa.put(".--.", "P");
        mapa.put("--.-", "Q");
        mapa.put(".-.", "R");
        mapa.put("...", "S");
        mapa.put("-", "T");
        mapa.put("..-", "U");
        mapa.put("...-", "V");
        mapa.put(".--", "W");
        mapa.put("-..-", "X");
        mapa.put("-.--", "Y");
        mapa.put("--..", "Z");
        mapa.put(".----", "1");
        mapa.put("..---", "2");
        mapa.put("...--", "3");
        mapa.put("....-", "4");
        mapa.put("......", "5");
        mapa.put("-....", "6");
        mapa.put("--...", "7");
        mapa.put("---..", "8");
        mapa.put("------", "0");
    }

    @GetMapping
    public String inicio() {
        return "Traductor de clave Morse";
    }

    @GetMapping("/{code}")
    public String translateToSpanish(@PathVariable String code) {
        StringBuilder resultado = new StringBuilder();

        //String       code = ".-- -.. 3esp --. .-.. 3esp --. ---."

        String palabras[] = code.split("   ");
        //String palabras[] = [ ".-- -.." , "--. .-.." , "--. ---." ]v
        for (String palabra : palabras) {

            //para cada elemento de palabras[]

            String letras[] = palabra.split(" ");
            //String letras[] = [ ".--", "-.." ]
            for (String letra : letras) {
                if (mapa.containsKey(letra)) {
                    resultado.append(mapa.get(letra));
                } else
                    return "No existe la letra: " + letra;
            }

            //Espacio entre palabras
            resultado.append(" ");
        }
        return resultado.toString();

    }
}
