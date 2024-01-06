package com.practicandoConApis.morseCode.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/morse")
public class MorseController {
    private final Map<String, String> MORSE_CODE = new HashMap<String, String>() {{
        put(".-", "A");
        put("-...", "B");
        put("-.-.", "C");
        put("-..", "D");
        put(".", "E");
        put("..-.", "F");
        put("--.", "G");
        put("....", "H");
        put("..", "I");
        put(".---", "J");
        put("-.-", "K");
        put(".-..", "L");
        put("--", "M");
        put("-.", "N");
        put("---", "O");
        put(".--.", "P");
        put("--.-", "Q");
        put(".-.", "R");
        put("...", "S");
        put("-", "T");
        put("..-", "U");
        put("...-", "V");
        put(".--", "W");
        put("-..-", "X");
        put("-.--", "Y");
        put("--..", "Z");
        put(".----", "1");
        put("..---", "2");
        put("...--", "3");
        put("....-", "4");
        put("......", "5");
        put("-....", "6");
        put("--...", "7");
        put("---..", "8");
        put("------", "0");
        put("..--..", "?");
        put("-.-.--", "!");
        put(".-.-.-", ".");
        put("--..--", ",");
    }};

    @GetMapping
    public String getCode(@RequestParam("code") String code) {
        String words[] = code.split("   ");
        return Arrays.stream(words).map(
                word -> Arrays.stream(word.split(" ")).map(
                        MORSE_CODE::get
                ).collect(Collectors.joining())
        ).collect(Collectors.joining(" "));
    }
}