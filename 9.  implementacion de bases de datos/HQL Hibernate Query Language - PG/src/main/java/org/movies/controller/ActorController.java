package org.movies.controller;

import org.movies.dtos.ActorResponseDTO;
import org.movies.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping
    public ResponseEntity<List<ActorResponseDTO>> getActors() {
        return ResponseEntity.ok(actorService.getAllActors());
    }

    @GetMapping("/favorite-movie/not-null")
    public ResponseEntity<List<ActorResponseDTO>> getActorsByFavoriteMovieNotNull() {
        return ResponseEntity.ok(actorService.getActorsByFavoriteMovieNotNull());
    }
}
