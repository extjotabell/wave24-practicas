package com.JPA.demo.controller;

import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.dto.PersonDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

//    @Autowired
//    IPersonService personService;

    @PostMapping("/")
    public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO personDTO){
        return null;
    }

    @GetMapping("/")
    public ResponseEntity<List<PersonDTO>> getAll(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getById(@PathVariable Integer id){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteById(@PathVariable Integer id){
        return null;
    }
}
