package org.linktraker.linktrackerapi.controller;

import org.linktraker.linktrackerapi.dto.CounterDTO;
import org.linktraker.linktrackerapi.service.IURIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.css.Counter;

@RestController
@RequestMapping("/metrics")
public class MetricController {
    private final IURIService uriService;

    @Autowired
    public MetricController(IURIService uriService) {
        this.uriService = uriService;
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<CounterDTO> getCounterOfRedirects(@PathVariable Integer linkId) {
        return ResponseEntity.ok(uriService.getRedirectCount(linkId));
    }
}
