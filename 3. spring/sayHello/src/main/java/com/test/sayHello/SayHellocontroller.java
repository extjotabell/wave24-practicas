package com.test.sayHello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHellocontroller {

    @GetMapping
    public String sayHello() {
        return "Hello world";
    }

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello world "+name;
    }
}
