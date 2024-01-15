package com.spring.responseuno.demo.controller;

import com.spring.responseuno.demo.dto.LinkDTO;
import com.spring.responseuno.demo.entity.Link;
import com.spring.responseuno.demo.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkController {

    @Autowired
    LinkService ls;

    @PostMapping("/link")
    public ResponseEntity<LinkDTO> saveLinkId(@RequestBody String url){
        return new ResponseEntity<>(new LinkDTO(ls.saveLinkId(url)), HttpStatus.OK);
    }

}
