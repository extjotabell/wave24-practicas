package com.JPA.demo.controller;

import com.JPA.demo.dto.ClientDTO;
import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.service.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
        return ResponseEntity.ok(
                clientService.saveEntity(clientDTO)
        );
    }

    @GetMapping("/")
    public ResponseEntity<Page<ClientDTO>> getAll(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok(
                clientService.getAllEntities(page, size)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getById(@PathVariable Integer id){
        return ResponseEntity.ok(
                clientService.getEntityById(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteById(@PathVariable Integer id){
        return null;
    }

    @GetMapping("findByEmail/{email}")
    public ResponseEntity<ClientDTO> getByEmail(@PathVariable String email){
        return ResponseEntity.ok(
                clientService.findByEmail(email)
        );
    }
}
