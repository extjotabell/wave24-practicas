package org.movies.service.implementation;

import org.movies.configs.ModelMapper;
import org.movies.dtos.ActorResponseDTO;
import org.movies.entity.Actor;
import org.movies.repository.MovieRepository;
import org.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImp implements MovieService {

    @Autowired
    private MovieRepository repository;

    private ModelMapper modelMapper = new ModelMapper();

}
