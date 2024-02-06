package com.JPA.demo.controller;

import com.JPA.demo.dto.InvoiceDTO;
import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.repository.interfaces.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("invoice")
public class InvoiceController {

    @Autowired
    private IInvoiceService invoiceService;

    @PostMapping("/")
    public ResponseEntity<InvoiceDTO> create(@RequestBody InvoiceDTO invoiceDTO){
        return null;
    }

    @GetMapping("/")
    public ResponseEntity<List<InvoiceDTO>> getAll(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDTO> getById(@PathVariable Integer id){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteById(@PathVariable Integer id){
        return null;
    }
}
