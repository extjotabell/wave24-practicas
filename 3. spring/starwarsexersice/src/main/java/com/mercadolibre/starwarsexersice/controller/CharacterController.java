package com.mercadolibre.starwarsexersice.controller;

import com.mercadolibre.starwarsexersice.dto.CharacterDTO;
import com.mercadolibre.starwarsexersice.repository.CharacterRepositoryImpl;
import com.mercadolibre.starwarsexersice.service.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class CharacterController {
    @GetMapping("/characters-by-namemach/{nameMach}")
    public ResponseEntity<List<CharacterDTO>> charactersByNameMach(@PathVariable String nameMach){
        List<CharacterDTO> characters = new CharacterService(new CharacterRepositoryImpl()).findEntityByNameMach(nameMach);
        if(Objects.isNull(characters)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(characters);
    }
}
