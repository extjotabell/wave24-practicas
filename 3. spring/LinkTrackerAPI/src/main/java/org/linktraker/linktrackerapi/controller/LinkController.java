package org.linktraker.linktrackerapi.controller;

import org.linktraker.linktrackerapi.dto.CreateUrlDTO;
import org.linktraker.linktrackerapi.dto.RedirectDTO;
import org.linktraker.linktrackerapi.model.URI;
import org.linktraker.linktrackerapi.service.IURIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/link")
public class LinkController {
    private final IURIService uriService;

    @Autowired
    public LinkController(IURIService uriService) {
        this.uriService = uriService;
    }

    @GetMapping
    public ResponseEntity<List<URI>> getAll() {
        return ResponseEntity.ok(uriService.getAll());
    }

    @PostMapping
    public ResponseEntity<Integer> saveLinkTracking(@RequestBody CreateUrlDTO url) {
        return ResponseEntity.ok(uriService.saveLinkTracking(url));
    }

    @GetMapping("/{id}")
    public RedirectView getLinkTracking(@PathVariable Integer id, @RequestParam String password) {
        return new RedirectView(uriService.getLinkToRedirect(new RedirectDTO(id, password)));
    }
}
