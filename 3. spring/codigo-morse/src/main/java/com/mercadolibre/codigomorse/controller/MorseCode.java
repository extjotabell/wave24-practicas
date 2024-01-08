package com.mercadolibre.codigomorse.controller;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class MorseCode {
    private String text;
    private final Map<String, String> CODES = new HashMap<>() {{
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

    public MorseCode(String text) {
        this.text = text;
    }

    public MorseCode() {
    }

    public String deserialize(){
        String[] words = this.text.split("   ");

        return Arrays.stream(words).map((word) -> {
            return Arrays.stream(word.split(" ")).map(this.CODES::get).collect(Collectors.joining());
        }).collect(Collectors.joining(" "));
    }
    @Override
    public String toString() {
        return "MorseCode{" +
                "text='" + text + '\'' +
                '}';
    }
}
