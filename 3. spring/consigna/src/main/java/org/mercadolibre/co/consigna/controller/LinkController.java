package org.mercadolibre.co.consigna.controller;

import org.mercadolibre.co.consigna.dto.LinkDTO;
import org.mercadolibre.co.consigna.entity.Link;
import org.mercadolibre.co.consigna.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<LinkDTO> createLink(@RequestBody Link link){
        LinkDTO linkDTO = this.linkService.create(link);
        return ResponseEntity.ok(linkDTO);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<LinkDTO> redirect(@PathVariable Integer linkId){
        LinkDTO linkDTO = this.linkService.create(linkId);
        return ResponseEntity.ok(linkDTO);
    }




}
