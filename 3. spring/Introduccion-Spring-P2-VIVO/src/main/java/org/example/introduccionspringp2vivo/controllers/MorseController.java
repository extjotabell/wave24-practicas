package org.example.introduccionspringp2vivo.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/morse")
public class MorseController {

    private static final Map<String, Character> CODIGO_LETRA = new HashMap<>();

    static {
        CODIGO_LETRA.put(".-", 'A');
        CODIGO_LETRA.put("-...", 'B');
        CODIGO_LETRA.put("-.-.", 'C');
        CODIGO_LETRA.put("-..", 'D');
        CODIGO_LETRA.put(".", 'E');
        CODIGO_LETRA.put("..-.", 'F');
        CODIGO_LETRA.put("--.", 'G');
        CODIGO_LETRA.put("....", 'H');
        CODIGO_LETRA.put("..", 'I');
        CODIGO_LETRA.put(".---", 'J');
        CODIGO_LETRA.put("-.-", 'K');
        CODIGO_LETRA.put(".-..", 'L');
        CODIGO_LETRA.put("--", 'M');
        CODIGO_LETRA.put("-.", 'N');
        CODIGO_LETRA.put("---", 'O');
        CODIGO_LETRA.put(".--.", 'P');
        CODIGO_LETRA.put("--.-", 'Q');
        CODIGO_LETRA.put(".-.", 'R');
        CODIGO_LETRA.put("...", 'S');
        CODIGO_LETRA.put("-", 'T');
        CODIGO_LETRA.put("..-", 'U');
        CODIGO_LETRA.put("...-", 'V');
        CODIGO_LETRA.put(".--", 'W');
        CODIGO_LETRA.put("-..-", 'X');
        CODIGO_LETRA.put("-.--", 'Y');
        CODIGO_LETRA.put("--..", 'Z');
        CODIGO_LETRA.put("-----", '0');
        CODIGO_LETRA.put(".----", '1');
        CODIGO_LETRA.put("..---", '2');
        CODIGO_LETRA.put("...--", '3');
        CODIGO_LETRA.put("....-", '4');
        CODIGO_LETRA.put(".....", '5');
        CODIGO_LETRA.put("-....", '6');
        CODIGO_LETRA.put("--...", '7');
        CODIGO_LETRA.put("---..", '8');
        CODIGO_LETRA.put("----.", '9');
        CODIGO_LETRA.put(".-.-.-", '.');
        CODIGO_LETRA.put("--..--", ',');
        CODIGO_LETRA.put("..--..", '?');
        CODIGO_LETRA.put("-.-.--", '!');
    }

    @GetMapping("/decodificar/{morseCode}")
    public String deCodificar(@PathVariable String morseCode) {
        StringBuilder palabra = new StringBuilder();
        StringBuilder frase = new StringBuilder();
        String[] palabras = morseCode.split("   ");

        for (String palabraMorse : palabras) {
            String[] codigos = palabraMorse.split(" ");
            for (String codigo : codigos) {
                if (CODIGO_LETRA.containsKey(codigo)) {
                    palabra.append(CODIGO_LETRA.get(codigo));
                } else {
                    palabra.append("?");
                }
            }
            frase.append(palabra).append(" ");
            palabra = new StringBuilder();
        }

        return frase.toString();
        
    }

}
