package com.example.sport;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SportsRestController {

    private List<Sport> sportList = new ArrayList<>(Arrays.asList(
            new Sport("futbol", 2),
            new Sport("tenis", 1),
            new Sport("basquet", 3)
    ));

    private List<SportPersonDto> sportPersonList = new ArrayList<>(Arrays.asList(
            new SportPersonDto("Mel", "Limachi", "futbol")
    ));

    @GetMapping("/findSport")
    public List<Sport> findSports() {
        return sportList;
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSportByName(@PathVariable String name) {
        Sport sport = findClassSportByName(name);
        if(sport != null) {
            return ResponseEntity.ok(sport.toString());
        }
        else {
            return ResponseEntity.badRequest().body("No se encontro un deporte con el nombre: " + name);
        }
    }

    private Sport findClassSportByName(String name) {
        return sportList.stream().filter(sport -> sport.getName().equals(name)).findFirst().orElse(null);
    }

    @GetMapping("/findSportPerson")
    public ResponseEntity<List<SportPersonDto>> findSportPerson() {
        List<SportPersonDto> sports = new ArrayList<>();
        sportPersonList.stream().filter(person -> person.getSport() != null).
                forEach(person -> sports.add(new SportPersonDto(person.getName(), person.getLastName(), person.getSport())));
        return ResponseEntity.ok(sports);
    }

}