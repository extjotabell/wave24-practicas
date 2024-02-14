package com.jpa.integrador.controller;

import com.jpa.integrador.dto.SuccessDTO;
import com.jpa.integrador.dto.request.SaleRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;
import com.jpa.integrador.dto.response.SaleListResponseDTO;
import com.jpa.integrador.dto.response.SaleResponseDTO;
import com.jpa.integrador.exception.DBConnectionException;
import com.jpa.integrador.exception.NotFoundException;
import com.jpa.integrador.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class SaleController {
    ISaleService saleService;

    @Autowired
    public SaleController(ISaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/sale")
    public ResponseEntity<SuccessDTO> addSale(@RequestBody SaleRequestDTO dto){
        if(Boolean.TRUE.equals(saleService.addSale(dto)))
            return ResponseEntity.ok().body(new SuccessDTO("Se agrego una nueva venta", 201));
        else
            throw new DBConnectionException(
                    "No se pudo registrar la compra. Por favor, inténtelo de nuevo."
            );
    }

    @GetMapping("/sale")
    public ResponseEntity<SaleListResponseDTO> findAllSales(){
        return ResponseEntity.ok().body(saleService.findAllSales());
    }

    @GetMapping("/sale/{id}")
    public ResponseEntity<SaleResponseDTO> findOneSale(@PathVariable Integer id){

        return ResponseEntity.ok().body(saleService.findOneSale(id));
    }

    @PutMapping("/sale/{id}")
    public ResponseEntity<SuccessDTO> updateSale(@PathVariable Integer id, @RequestBody SaleRequestDTO saleRequestDTO){
        if(Boolean.TRUE.equals(saleService.updateSale(id, saleRequestDTO)))
            return ResponseEntity.ok().body(new SuccessDTO("Se modifico la venta", 201));
        else
            throw new NotFoundException("La venta que intenta modificar no existe");
    }

    @DeleteMapping("/sale/{number}")
    public ResponseEntity<SuccessDTO> deleteSale(@PathVariable("number") Integer id){
        if(Boolean.TRUE.equals(saleService.deleteSale(id)))
            return ResponseEntity.ok().body(new SuccessDTO("Se elimino la venta", 201));
        else
            throw new DBConnectionException("No se pudo eliminar la venta. Por favor, inténtelo de nuevo.");
    }

    @GetMapping("/sale/findByDate")
    public ResponseEntity<SaleListResponseDTO> findAllSalesByDate(@RequestParam("date") String date){
        SaleListResponseDTO list =  saleService.searchSaleByDate(date);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/sale/clothes/{number}")
    public ResponseEntity<ClothesListResponseDTO> findAllSalesBySaleId(@PathVariable("number") Integer id){
        ClothesListResponseDTO list =  saleService.searchClothesBySaleId(id);
        return ResponseEntity.ok().body(list);
    }
}
