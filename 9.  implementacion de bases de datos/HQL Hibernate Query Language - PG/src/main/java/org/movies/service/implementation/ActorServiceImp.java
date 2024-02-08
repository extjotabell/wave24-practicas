package org.movies.service.implementation;

import org.movies.configs.ModelMapper;
import org.movies.dtos.ActorResponseDTO;
import org.movies.entity.Actor;
import org.movies.repository.ActorRepository;
import org.movies.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActorServiceImp implements ActorService {

    @Autowired
    private ActorRepository repository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ActorResponseDTO> getAllActors() {
        List<Actor> actors = repository.findAll();
        return actors.stream().map(actor -> modelMapper.map(actor, ActorResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ActorResponseDTO> getActorsByFavoriteMovieNotNull() {
        List<Actor> actors = repository.findByFavoriteMovieNotNull().orElseThrow(RuntimeException::new);
        return actors.stream().map(actor -> modelMapper.map(actor, ActorResponseDTO.class)).collect(Collectors.toList());
    }
}
