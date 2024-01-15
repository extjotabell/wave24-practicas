package com.Link.link.controller;

import com.Link.link.dto.LinkDTO;
import com.Link.link.entity.Link;
import com.Link.link.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    @Autowired
    private ILinkService linkService;
    @PostMapping(value = "/link")
    public ResponseEntity<LinkDTO> createLink(@RequestBody Link link){
        return ResponseEntity.ok(this.linkService.create(link));
    }
    @GetMapping("/link/{linkId}")
    public ResponseEntity<Link> redirect(@PathVariable Link linkId){
        return ResponseEntity.ok(this.linkService.redirect(linkId));
    }
}


