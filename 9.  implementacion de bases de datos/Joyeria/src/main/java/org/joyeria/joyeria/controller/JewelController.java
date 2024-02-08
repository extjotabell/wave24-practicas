package org.joyeria.joyeria.controller;

import jakarta.validation.Valid;
import org.joyeria.joyeria.dto.Jewel.CreateJewelWithoutIdDTO;
import org.joyeria.joyeria.dto.Jewel.UpdateJewelDTO;
import org.joyeria.joyeria.dto.Response.ResponseDTO;
import org.joyeria.joyeria.service.interfaces.IJewelService;
import org.joyeria.joyeria.sort.JewelSortField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewelry")
@Validated
public class JewelController {
    private final IJewelService jewelService;

    @Autowired
    public JewelController(IJewelService jewelService) {
        this.jewelService = jewelService;
    }

    @GetMapping("/new")
    public ResponseEntity<ResponseDTO> newJewel(@RequestBody @Valid CreateJewelWithoutIdDTO jewel) {
        return ResponseEntity
                .ok(ResponseDTO.ok("Created new jewel successfully", jewelService.saveJewel(jewel)));
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllJewels(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "ASC") Sort.Direction sort,
            @RequestParam(defaultValue = "ID") JewelSortField sortField
    ) {
        return ResponseEntity
                .ok(
                        ResponseDTO
                                .ok(
                                        "List of all Jewels",
                                        jewelService.getAllJewels(page, size, sort, sortField)
                                )
                );
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> logicDeleteJewel(@PathVariable Long id) {
        return ResponseEntity
                .ok(ResponseDTO.ok("Jewel deleted successfully", jewelService.logicDeleteJewel(id)));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateJewel(
            @PathVariable Long id,
            @RequestBody @Valid UpdateJewelDTO jewel
    ) {
        return ResponseEntity
                .ok(ResponseDTO.ok("Jewel updated successfully", jewelService.updateJewel(id, jewel)));
    }
}
