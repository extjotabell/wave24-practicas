package com.spring.Deportistas.Controller;

import com.spring.Deportistas.Classes.Deporte;
import com.spring.Deportistas.Classes.Persona;
import com.spring.Deportistas.Classes.PersonaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/deportistas")
public class PersonaController {

    Persona persona1 = new Persona("Hernan", "Hernandez", 20);
    Persona persona2 = new Persona("Martin", "Martinez", 25);

    Deporte deporte1 = new Deporte("Futbol", "Amateur");
    Deporte deporte2 = new Deporte("Natación", "Profesional");

    List<Persona> personas = List.of(persona1, persona2);
    List<Deporte> deportes = List.of(deporte1, deporte2);

    @GetMapping
    public String PersonaController(){
        return "Pagina principal deportistas";
    }

    @GetMapping("/findSports")
    private ResponseEntity<List<Deporte>> verTodosLosDeportes(){

        if(deportes.stream().findAny().isPresent()){
            return ResponseEntity.ok(deportes);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findSports/{name}")
    private ResponseEntity<List<Deporte>> buscarDeporte(@PathVariable("name") String nombre) {
        if(deportes.stream().findAny().isPresent()) {

            var deporteEncontrado = deportes.stream()
                    .filter(deporte -> deporte.getNombre().equals(nombre));
            return ResponseEntity.ok(deporteEncontrado.toList());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findSportsPersons")
    private List<PersonaDTO> obtenerPersonasDeportistas(){

        PersonaDTO personaDTO = new PersonaDTO(persona1.getNombre(), persona1.getApellido(), deporte1.getNombre());
        PersonaDTO personaDTO2 = new PersonaDTO(persona2.getNombre(), persona2.getApellido(), deporte2.getNombre());

        return List.of(personaDTO, personaDTO2);
    }

}
