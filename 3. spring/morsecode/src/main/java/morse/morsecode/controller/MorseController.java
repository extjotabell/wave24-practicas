package morse.morsecode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping("morse")
public class MorseController {
    private final Map<String, String> codigos = new HashMap<>() {{
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

    @GetMapping("{code}")
    String translateToSpanish(@PathVariable String code){
        var words = code.split("   ");
       /* String text = "";
        for(String word: words){
            var splitOfLetters = word.split(" ");
            for(String letter: splitOfLetters){
                if(codigos.containsKey(letter))
                    text += codigos.get(letter);
            }
            text += " ";
        }
        return text;*/
        return Arrays.stream(words).map((word) -> {
            return Arrays.stream(word.split(" ")).map(this.codigos::get).collect(Collectors.joining());
        }).collect(Collectors.joining(" "));
    }
}
