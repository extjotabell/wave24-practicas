package com.spring.responseuno.demo.controller;

import com.spring.responseuno.demo.model.Compra;
import com.spring.responseuno.demo.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping("/new")
    public ResponseEntity<?> saveCompra (@RequestBody Compra compra) {
        return ResponseEntity.ok(compraService.saveCompra(compra));
    }

}
