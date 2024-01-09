package com.spring.responseuno.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanRestController {


    @GetMapping("/{numero}")
    public String GetRomano(@PathVariable int numero){

    }
}
