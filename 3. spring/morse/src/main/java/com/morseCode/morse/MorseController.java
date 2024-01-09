package com.morseCode.morse;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/morse")
public class MorseController {
Map<String, String> morseDictionary = new HashMap<>();

public MorseController(){
    morseDictionary.put(".-", "A");
    morseDictionary.put("-...", "B");
    morseDictionary.put("-.-.", "C");
    morseDictionary.put("-..", "D");
    morseDictionary.put(".", "E");
    morseDictionary.put("..-.", "F");
    morseDictionary.put("--.", "G");
    morseDictionary.put("....", "H");
    morseDictionary.put("..", "I");
    morseDictionary.put(".---", "J");
    morseDictionary.put("-.-", "K");
    morseDictionary.put(".-..", "L");
    morseDictionary.put("--", "M");
    morseDictionary.put("-.", "N");
    morseDictionary.put("---", "O");
    morseDictionary.put(".--.", "P");
    morseDictionary.put("--.-", "Q");
    morseDictionary.put(".-.", "R");
    morseDictionary.put("...", "S");
    morseDictionary.put("-", "T");
    morseDictionary.put("..-", "U");
    morseDictionary.put("...-", "V");
    morseDictionary.put(".--", "W");
    morseDictionary.put("-..-", "X");
    morseDictionary.put("-.--", "Y");
    morseDictionary.put("--..", "Z");
    morseDictionary.put(".----", "1");
    morseDictionary.put("..---", "2");
    morseDictionary.put("...--", "3");
    morseDictionary.put("....-", "4");
    morseDictionary.put(".....", "5");
    morseDictionary.put("-....", "6");
    morseDictionary.put("--...", "7");
    morseDictionary.put("---..", "8");
    morseDictionary.put("----.", "9");
    morseDictionary.put("-----", "0");
}
    @GetMapping
    public String traslateToSpanish(@RequestParam String code){
    String result = "";
    var splitOfWords = code.split("   ");
        for(String word : splitOfWords){
            var splitOfLetters = word.split(" ");

            for(String letter : splitOfLetters){
                if(morseDictionary.containsKey(letter)){
                    result += morseDictionary.get(letter);
                }
                else
                    return "No existe le caracter: " + letter;
            }
            result += " ";
        }
        return result;
    }
}
