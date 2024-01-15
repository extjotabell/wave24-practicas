package com.example.tracker.controller;


import com.example.tracker.dto.IdLinkDTO;
import com.example.tracker.dto.LinkDTO;
import com.example.tracker.services.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TrackerController {


    @Autowired
    private ILinkService linkService;


    @PostMapping("/link")
    public ResponseEntity<IdLinkDTO> createLink(@RequestBody String url){
        //devolver el linkid
        return ResponseEntity.ok(linkService.createLink(url));
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<void> getLink(@PathVariable Integer id){
        linkService.getLink(id)
        return ResponseEntity.ok(linkService.getLink(id));
    }


}
