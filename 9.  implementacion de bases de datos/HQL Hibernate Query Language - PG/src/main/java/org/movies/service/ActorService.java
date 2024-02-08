package org.movies.service;

import org.movies.dtos.ActorResponseDTO;

import java.util.List;

public interface ActorService {

    List<ActorResponseDTO> getAllActors();

    List<ActorResponseDTO> getActorsByFavoriteMovieNotNull();
}
