package com.mercadolibre.sportexercise.controller;

import com.mercadolibre.sportexercise.classes.Person;
import com.mercadolibre.sportexercise.classes.Sport;
import com.mercadolibre.sportexercise.dto.PersonSportDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SportController {
    private final Sport FOTBALL =  new Sport("Futbol", 1);
    private final Sport BASKET = new Sport("Basketball", 2);
    private final Sport TENIS = new Sport("Tenis", 3);
    private final List<Sport> SPORTS = new ArrayList<>(List.of(FOTBALL, BASKET, TENIS));

    private final Person PERSON1 = new Person("Joaco", "Cabello", 25);
    private final Person PERSON2 = new Person("Doris", "Salazar", 20);
    private final Person PERSON3 = new Person("Alejandro", "Knubel", 20);
    private final Person PERSON4 = new Person("Victoria", "Marquez", 20);

    private final List<PersonSportDTO> PERSONSSPORT = new ArrayList<>(List.of(
            new PersonSportDTO(PERSON1.getFirstName(), PERSON1.getLastName(), FOTBALL.getName()),
            new PersonSportDTO(PERSON2.getFirstName(), PERSON2.getLastName(), BASKET.getName()),
            new PersonSportDTO(PERSON3.getFirstName(), PERSON3.getLastName(), FOTBALL.getName()),
            new PersonSportDTO(PERSON4.getFirstName(), PERSON4.getLastName(), TENIS.getName())
    ));

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> findSports(){
        return ResponseEntity.ok(this.SPORTS);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Integer> findSportByName(@PathVariable String name){
        Sport sportFinded = this.SPORTS.stream().filter(sport -> sport.getName().equalsIgnoreCase(name)).findFirst().orElseThrow();
        return ResponseEntity.ok(sportFinded.getLevel());
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonSportDTO>> findSportsPersons(){
        return ResponseEntity.ok(this.PERSONSSPORT);
    }
}
