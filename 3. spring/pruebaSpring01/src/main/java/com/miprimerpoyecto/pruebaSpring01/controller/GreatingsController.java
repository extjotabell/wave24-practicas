package com.miprimerpoyecto.pruebaSpring01.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController //declarar que es controlador de tipo rest
//@RequestMapping()
public class GreatingsController {

    Map<Integer,String> diccionario = new HashMap<>();

    public GreatingsController(){
    diccionario.put(1, "I");
    diccionario.put(2, "II");
    diccionario.put(3, "III");
    diccionario.put(4, "IV");
    diccionario.put(5, "V");
    diccionario.put(6, "VI");
    diccionario.put(7, "VII");
    diccionario.put(8, "VIII");
    diccionario.put(9, "IX");
    diccionario.put(10, "X");
    diccionario.put(13, "XIII");
    diccionario.put(50,"L");
    diccionario.put(100,"C");
    diccionario.put(500,"D");
    diccionario.put(1000,"M");}

    @GetMapping()
    public Map<Integer,String> index() {
        return diccionario;
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello "+ name;
    }

    @GetMapping("/bye/{name}")
    public String bye(@PathVariable String name) {
        return "Bye "+ name;
    }

    @GetMapping("/romanos/{numero}")
    public String findNumber(@PathVariable String numero) {
        int num = Integer.parseInt(numero);
        if(diccionario.containsKey(num)){
            return diccionario.get(num);
        }else{
            return ("No esta en mi registro");
        }

    }

}
