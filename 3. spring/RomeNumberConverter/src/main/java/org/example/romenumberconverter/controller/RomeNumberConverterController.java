package org.example.romenumberconverter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/converter")
public class RomeNumberConverterController {

    @GetMapping()
    public String principalPage(){
        return "This the principal page";
    }

    @GetMapping("/numberconverter/{number}")
    public String romeNumberConverter(@PathVariable Integer number){
        String romeNumber = "";

        switch (number){
            case 1 -> romeNumber = "I";
            case 2 -> romeNumber = "II";
            case 3 -> romeNumber = "III";
            case 4 -> romeNumber = "IV";
            case 5 -> romeNumber = "V";
            case 6 -> romeNumber = "VI";
            case 7 -> romeNumber = "VII";
            case 8 -> romeNumber = "VIII";
            case 9 -> romeNumber = "IX";
            case 10 -> romeNumber = "X";
            case 11 -> romeNumber = "XI";
            case 12 -> romeNumber = "XII";
            case 13 -> romeNumber = "XIII";
            case 50 -> romeNumber = "L";
            case 100 -> romeNumber = "C";
            case 500 -> romeNumber = "D";
            case 1000 -> romeNumber = "M";
        }
        return "The number: " + number + " in rome number is: " + romeNumber;
    }
}
