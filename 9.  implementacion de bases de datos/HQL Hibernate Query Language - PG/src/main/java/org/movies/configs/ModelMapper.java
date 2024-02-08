package org.movies.configs;

import org.movies.dtos.ActorResponseDTO;
import org.movies.dtos.MovieResponseDTO;
import org.movies.entity.Actor;
import org.movies.entity.Movie;

public class ModelMapper {

    public Movie map(MovieResponseDTO dto, Class c) {
        if(c == Movie.class) {
            return new Movie(
                    null,
                    dto.title(),
                    dto.rating(),
                    dto.awards(),
                    dto.releaseDate(),
                    dto.length(),
                    null,
                    null,
                    null
            );
        }
        return null;
    }

    public Actor map(ActorResponseDTO dto, Class c) {
        if(c == Actor.class) {
            return new Actor(
                    null,
                    dto.firstName(),
                    dto.lastName(),
                    dto.rating(),
                    null,
                    null,
                    dto.favoriteMovie() != null ? this.map(dto.favoriteMovie(), Movie.class) : null
            );
        }
        return null;
    }

    public MovieResponseDTO map(Movie e, Class c) {
        if(c == MovieResponseDTO.class) {
            return new MovieResponseDTO(
                    e.getId(),
                    e.getTitle(),
                    e.getReleaseDate(),
                    e.getLength(),
                    e.getRating(),
                    e.getAwards()
            );
        }
        return null;
    }

    public ActorResponseDTO map(Actor e, Class c) {
        if(c == ActorResponseDTO.class) {
            return new ActorResponseDTO(
                    e.getFirstName(),
                    e.getLastName(),
                    e.getRating(),
                    e.getFavoriteMovie() != null ? this.map(e.getFavoriteMovie(), MovieResponseDTO.class) : null
            );
        }
        return null;
    }


}
