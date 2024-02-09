package org.showroom.showroom.controller;

import org.showroom.showroom.dto.SuccessDTO;
import org.showroom.showroom.dto.request.ClothRequestDTO;
import org.showroom.showroom.dto.response.ClothesListResponseDTO;
import org.showroom.showroom.dto.response.ClothesResponseDTO;
import org.showroom.showroom.service.IClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClothController {

    @Autowired
    IClothService clothService;

    @PostMapping("/clothes")
    public ResponseEntity<SuccessDTO> addCloth(@RequestBody ClothRequestDTO clothRequestDTO){
        if(clothService.addCloth(clothRequestDTO))
            return ResponseEntity.ok().body(new SuccessDTO("Se agrego una nueva prenda", 201));
        else
            throw new RuntimeException();
    }

    @GetMapping("/clothes")
    public ResponseEntity<ClothesListResponseDTO> findAllClothes(){
        ClothesListResponseDTO dto = clothService.findAllCloth();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/clothes/{code}")
    public ResponseEntity<ClothesResponseDTO> findClothByCode (@PathVariable("code") String code){
        ClothesResponseDTO dto = clothService.findOneCloth(code);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/clothes/{code}")
    public ResponseEntity<SuccessDTO> updateClothByCode (@PathVariable("code") String code,
                                                         @RequestBody ClothRequestDTO cloth){
        if(clothService.updateCloth(code, cloth))
            return ResponseEntity.ok().body(new SuccessDTO("La prenda se actualizo exitosamente", 201));
        else
            throw new RuntimeException();
    }

    @DeleteMapping("/clothes/{code}")
    public ResponseEntity<SuccessDTO> deleteClothByCode (@PathVariable("code") String code){
        if(clothService.deleteCloth(code))
            return ResponseEntity.ok().body(new SuccessDTO("La prenda se elemino exitosamente", 404));
        else
            throw new RuntimeException();
    }

    @GetMapping("/clothes/search/{size}")
    public ResponseEntity<ClothesListResponseDTO> findClothesBySize(@PathVariable("size") String size){
        ClothesListResponseDTO list = clothService.searchSaleBySize(size);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/clothes/contains")
    public ResponseEntity<ClothesListResponseDTO> findClothesByName(@RequestParam("name") String clothName){
        ClothesListResponseDTO list = clothService.searchClothesByName(clothName);
        return ResponseEntity.ok().body(list);
    }
}
