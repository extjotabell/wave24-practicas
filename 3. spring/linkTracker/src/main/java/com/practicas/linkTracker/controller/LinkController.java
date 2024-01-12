package com.practicas.linkTracker.controller;

import com.practicas.linkTracker.dto.LinkIdDTO;
import com.practicas.linkTracker.dto.LinkInvalidDTO;
import com.practicas.linkTracker.dto.LinkMetricDTO;
import com.practicas.linkTracker.entity.Link;
import com.practicas.linkTracker.service.LinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {
    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<LinkIdDTO> saveLink(@RequestBody Link link) {
        return ResponseEntity.ok(this.linkService.saveLink(link));
    }

    @GetMapping("/link/{linkId}")
    public RedirectView getLinkById(@PathVariable Integer linkId, @RequestParam String password) {
        return new RedirectView(this.linkService.getLinkById(linkId, password).getUrl());
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkMetricDTO> getRedirectsById(@PathVariable Integer linkId) {
        return ResponseEntity.ok(this.linkService.getRedirectsById(linkId));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<LinkInvalidDTO> invalidateLink(@PathVariable Integer linkId) {
        return ResponseEntity.ok(this.linkService.invalidateLink(linkId));
    }
}
