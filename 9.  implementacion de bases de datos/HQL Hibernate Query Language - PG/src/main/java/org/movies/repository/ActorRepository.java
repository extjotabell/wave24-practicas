package org.movies.repository;

import org.movies.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    Optional<List<Actor>> findByFavoriteMovieNotNull();
}
