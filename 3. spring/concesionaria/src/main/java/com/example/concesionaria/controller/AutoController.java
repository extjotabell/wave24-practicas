package com.example.concesionaria.controller;

import com.example.concesionaria.dto.AutoDTO;
import com.example.concesionaria.entity.Auto;
import com.example.concesionaria.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AutoController {


    //comunicar con los servicios
    @Autowired
    private AutoService autoService;

    @GetMapping("/vehicules")
    public ResponseEntity<List<AutoDTO>> showAutos(){
        return ResponseEntity.ok(autoService.getAutos());
    }

    @PostMapping("/vehicules")
    public ResponseEntity<Boolean> addAuto(@RequestBody Auto auto){
        return ResponseEntity.ok(autoService.crearAuto(auto));
    }

    @GetMapping("/vehicules/{id}")
    public ResponseEntity<AutoDTO> getAuto(@PathVariable Integer id){
        return ResponseEntity.ok(autoService.getAuto(id));
    }

    @GetMapping("/vehicules/dates")
    public ResponseEntity<List<AutoDTO>> getAutosByPrice(@RequestParam Double since, @RequestParam Double to){
        return ResponseEntity.ok(autoService.getAutosbyPrice(since, to));
    }

    @GetMapping("/vehicules/dates")
    public ResponseEntity<List<AutoDTO>> getAutosByDate(@RequestParam String since, @RequestParam String to) {
            return ResponseEntity.ok(autoService.getAutosbyDate(since,to));


    }

}
