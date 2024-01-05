package com.example.romannumber;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumberController {

     @GetMapping()
     public String principalPage(){
        return "Ingresa un numero luego de localhost:8080/";
     }

    @GetMapping("/{number}")
    public String toRoman(@PathVariable Integer number) {
         StringBuilder romanNumber = new StringBuilder();
         int[] numbers = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
         String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

         for (int i = 0; i < numbers.length; i++) {
             for (; number >= numbers[i]; number -= numbers[i]) {
                 romanNumber.append(romanNumbers[i]);
             }
         }
         return romanNumber.toString();
     }
}