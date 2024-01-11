package com.example.blog.controllers;

import com.example.blog.dtos.EntradaBlogDTO;
import com.example.blog.services.interfaces.BlogServiceInt;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogServiceInt blogService;

    @GetMapping
    public ResponseEntity<List<EntradaBlogDTO>> getEntradas(){
        List<EntradaBlogDTO> entradas = blogService.getEntradas();
        return ResponseEntity.ok(entradas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradaBlogDTO> getEntrada(Long id){
        EntradaBlogDTO entrada = blogService.getEntrada(id);
        return ResponseEntity.ok(entrada);
    }

    @PostMapping
    public ResponseEntity<EntradaBlogDTO> createEntrada(@RequestBody EntradaBlogDTO entradaBlog){
        EntradaBlogDTO entrada = blogService.createEntrada(entradaBlog);

        return ResponseEntity.ok(entrada);
    }

}
