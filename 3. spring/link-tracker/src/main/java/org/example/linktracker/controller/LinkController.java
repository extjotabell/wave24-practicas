package org.example.linktracker.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.example.linktracker.dto.LinkCreateDTO;
import org.example.linktracker.dto.LinkDTO;
import org.example.linktracker.dto.LinkMetricDTO;
import org.example.linktracker.exception.BadRequestException;
import org.example.linktracker.model.Link;
import org.example.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @PostMapping("/create")
    public ResponseEntity<LinkDTO> createLink(@RequestBody LinkCreateDTO link) {
        Link newLink = linkService.createLink(link.url(), link.password());
        LinkDTO newLinkDTO = new LinkDTO(newLink.getLinkId(), newLink.getUrl());
        return ResponseEntity.ok(newLinkDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> redirect(@PathVariable String id, HttpServletResponse httpServletResponse) throws IOException {
        try {
            Integer linkId = Integer.parseInt(id);
            Link link = linkService.redirectLink(linkId);
            httpServletResponse.sendRedirect(link.getUrl() + "?password=" + link.getPassword());
            return ResponseEntity.ok().build();
        } catch (NumberFormatException e) {
            throw new BadRequestException("Invalid link id.");
        }
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<LinkMetricDTO> getRedirectCount(@PathVariable String id) {
        try {
            Integer linkId = Integer.parseInt(id);
            Integer redirectCount = linkService.getRedirectCount(linkId);
            LinkMetricDTO linkMetricDTO = new LinkMetricDTO(linkId, redirectCount);
            return ResponseEntity.ok(linkMetricDTO);
        } catch (NumberFormatException e) {
            throw new BadRequestException("Invalid link id.");
        }
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<?> invalidateLink(@PathVariable String id) {
        try {
            Integer linkId = Integer.parseInt(id);
            linkService.invalidateLink(linkId);
            return ResponseEntity.ok().build();
        } catch (NumberFormatException e) {
            throw new BadRequestException("Invalid link id.");
        }
    }

}
