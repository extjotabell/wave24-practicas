package com.JPA.demo.controller;

import com.JPA.demo.dto.ClientDTO;
import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.repository.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @PostMapping("/")
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO clientDTO){
        return null;
    }

    @GetMapping("/")
    public ResponseEntity<List<ClientDTO>> getAll(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getById(@PathVariable Integer id){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteById(@PathVariable Integer id){
        return null;
    }
}
