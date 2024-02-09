package org.showroom.showroom.controller;

import org.showroom.showroom.dto.SuccessDTO;
import org.showroom.showroom.dto.request.SaleRequestDTO;
import org.showroom.showroom.dto.response.ClothesListResponseDTO;
import org.showroom.showroom.dto.response.SaleListResponseDTO;
import org.showroom.showroom.dto.response.SaleResponseDTO;
import org.showroom.showroom.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class SaleController {

    @Autowired
    ISaleService saleService;

    @PostMapping("/sale")
    public ResponseEntity<SuccessDTO> addSale(@RequestBody SaleRequestDTO dto){
        if(saleService.addSale(dto))
            return ResponseEntity.ok().body(new SuccessDTO("Se agrego una nueva venta", 201));
        else
            throw new RuntimeException();
    }

    @GetMapping("/sale")
    public ResponseEntity<SaleListResponseDTO> findAllSales(){

        return ResponseEntity.ok().body(saleService.findAllSales());
    }
    @GetMapping("/sale/{id}")
    public ResponseEntity<SaleResponseDTO> findOneSale(@PathVariable String id){

        return ResponseEntity.ok().body(saleService.findOneSale(id));
    }

    @PutMapping("/sale/{id}")
    public ResponseEntity<SuccessDTO> updateSale(@PathVariable String id, @RequestBody SaleRequestDTO saleRequestDTO){
        if(saleService.updateSale(id, saleRequestDTO))
            return ResponseEntity.ok().body(new SuccessDTO("Se modifico la venta", 201));
        else
            throw new RuntimeException();
    }

    @DeleteMapping("/sale/{number}")
    public ResponseEntity<SuccessDTO> deleteSale(@PathVariable(name = "number" ) String id){
        if(saleService.deleteSale(id))
            return ResponseEntity.ok().body(new SuccessDTO("Se elimino la venta", 201));
        else
            throw new RuntimeException();
    }

    @GetMapping("/sale/findByDate")
    public ResponseEntity<SaleListResponseDTO> findAllSalesByDate(@RequestParam("date") String date){
        SaleListResponseDTO list =  saleService.searchSaleByDate(LocalDate.parse(date));
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/sale/clothes/{number}")
    public ResponseEntity<ClothesListResponseDTO> findAllSalesBySaleId(@PathVariable("number") String id){
        ClothesListResponseDTO list =  saleService.searchClothesBySaleId(id);
        return ResponseEntity.ok().body(list);
    }
}
