package org.jewerly.lasperlas.controller;

import org.jewerly.lasperlas.dto.JewerlyDTO;
import org.jewerly.lasperlas.dto.MessageDTO;
import org.jewerly.lasperlas.dto.response.JewerlyUpdateResponseDTO;
import org.jewerly.lasperlas.service.interfaces.IJewerlyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JewerlyController {

    private IJewerlyService jewerlyService;

    public JewerlyController(IJewerlyService jewerlyService) {
        this.jewerlyService = jewerlyService;
    }

    @PostMapping("/new")
    public ResponseEntity<MessageDTO> saveJewerly(@RequestBody JewerlyDTO jewerlyDTO) {
        return ResponseEntity.ok(jewerlyService.saveEntity(jewerlyDTO));
    }

    @GetMapping()
    public ResponseEntity<List<JewerlyDTO>> getAllJewerly() {
        return ResponseEntity.ok(jewerlyService.getAllEntities());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<MessageDTO> deleteJewerly(@PathVariable Long id) {
        return ResponseEntity.ok(jewerlyService.deleteEntity(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<JewerlyUpdateResponseDTO> updateJewerly(@RequestBody JewerlyDTO jewerlyDTO , @PathVariable Long id) {
        return ResponseEntity.ok(jewerlyService.updateEntityById(jewerlyDTO, id));
    }
}
