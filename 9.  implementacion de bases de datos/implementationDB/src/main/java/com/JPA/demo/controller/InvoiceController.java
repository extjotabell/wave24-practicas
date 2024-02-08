package com.JPA.demo.controller;

import com.JPA.demo.dto.CountOfInvoicesDTO;
import com.JPA.demo.dto.InvoiceDTO;
import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.service.interfaces.IInvoiceService;
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
        return ResponseEntity.ok(
                invoiceService.saveEntity(invoiceDTO)
        );
    }

    @GetMapping("/")
    public ResponseEntity<List<InvoiceDTO>> getAll(){
        return ResponseEntity.ok(
                invoiceService.getAllEntities()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDTO> getById(@PathVariable Integer id){
        return ResponseEntity.ok(
                invoiceService.getEntityById(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteById(@PathVariable Integer id){
        return ResponseEntity.ok(
                invoiceService.deleteEntity(id)
        );
    }

    @GetMapping("/getCount")
    public ResponseEntity<List<CountOfInvoicesDTO>> getCountOfInvoices(){
        return ResponseEntity.ok(
                invoiceService.getCountOfInvoicesByClient()
        );
    }
}