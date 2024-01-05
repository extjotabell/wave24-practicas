package com.morseCode.morse.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/morse")
public class MorseController {
    Map<String, String> mapOfMorse = new HashMap<>();

    public MorseController() {
        mapOfMorse.put(".-", "A");
        mapOfMorse.put("-...", "B");
        mapOfMorse.put("-.-.", "C");
        mapOfMorse.put("-..", "D");
        mapOfMorse.put(".", "E");
        mapOfMorse.put("..-.", "F");
        mapOfMorse.put("--.", "G");
        mapOfMorse.put("....", "H");
        mapOfMorse.put("..", "I");
        mapOfMorse.put(".---", "J");
        mapOfMorse.put("-.-", "K");
        mapOfMorse.put(".-..", "L");
        mapOfMorse.put("--", "M");
        mapOfMorse.put("-.", "N");
        mapOfMorse.put("---", "O");
        mapOfMorse.put(".--.", "P");
        mapOfMorse.put("--.-", "Q");
        mapOfMorse.put(".-.", "R");
        mapOfMorse.put("...", "S");
        mapOfMorse.put("-", "T");
        mapOfMorse.put("..-", "U");
        mapOfMorse.put("...-", "V");
        mapOfMorse.put(".--", "W");
        mapOfMorse.put("-..-", "X");
        mapOfMorse.put("-.--", "Y");
        mapOfMorse.put("--..", "Z");
        mapOfMorse.put(".----", "1");
        mapOfMorse.put("..---", "2");
        mapOfMorse.put("...--", "3");
        mapOfMorse.put("....-", "4");
        mapOfMorse.put("......", "5");
        mapOfMorse.put("-....", "6");
        mapOfMorse.put("--...", "7");
        mapOfMorse.put("---..", "8");
        mapOfMorse.put("------", "0");
    }

    @GetMapping("/{code}")
    public String translateToSpanish(@PathVariable String code){
        String result = "";

        var splitOfWords = code.split("   ");
        for(String word : splitOfWords){
            var splitOfLetters = word.split(" ");
            for (String letter : splitOfLetters) {
                if (mapOfMorse.containsKey(letter)) {
                    result += mapOfMorse.get(letter);
                }
                else
                    return "No existe la letra: " + letter;
            }
            result += " ";
        }
        return result;

    }
    @GetMapping
    public String getMethod(){
        return "Soy un get";
    }
    @PostMapping
    public String postMethod(){
        return "Soy un post";
    }
    @PutMapping
    public String putMethod(){
        return "Soy un put";
    }
    @PatchMapping
    public String patchMethod(){
      return "Soy un patch";
    }
    @DeleteMapping
    public String deleteMethod(){
        return "Soy un delete";
    }
}
