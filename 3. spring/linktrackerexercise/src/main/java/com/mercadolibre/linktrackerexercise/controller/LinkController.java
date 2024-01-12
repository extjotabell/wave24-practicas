package com.mercadolibre.linktrackerexercise.controller;

import com.mercadolibre.linktrackerexercise.dto.CreateLinkDTO;
import com.mercadolibre.linktrackerexercise.dto.LinkIdDTO;
import com.mercadolibre.linktrackerexercise.dto.LinkQuantityRedirectDTO;
import com.mercadolibre.linktrackerexercise.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    private ILinkService linkService;

    @PostMapping("/")
    public ResponseEntity<LinkIdDTO> createLink(@RequestBody CreateLinkDTO createLinkDTO){
        return ResponseEntity.ok(this.linkService.createLink(createLinkDTO));
    }

    @GetMapping("/redirect/{linkId}")
    public RedirectView redirectLink(@PathVariable Integer linkId){
        String linkToRedirect = this.linkService.redirectLink(linkId);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(linkToRedirect);
        return redirectView;
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<LinkQuantityRedirectDTO> getQuantityRedirectByLinkId(@PathVariable Integer linkId){
        return ResponseEntity.ok(this.linkService.getLinkQuantityRedirect(linkId));
    }

    @PutMapping("/{linkId}")
    public ResponseEntity<Boolean> invalidateLink(@PathVariable Integer linkId){
        return ResponseEntity.ok(this.linkService.invalidateLink(linkId));
    }
}
