package org.laperla.service.implementation;

import org.laperla.configs.ModelMapper;
import org.laperla.dtos.JewerlyRequestDTO;
import org.laperla.entity.Jewerly;
import org.laperla.repository.JewerlyRepository;
import org.laperla.service.JewerlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JewerlyServiceImp implements JewerlyService {

    @Autowired
    private JewerlyRepository jewerlyRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public String newJewerly(JewerlyRequestDTO jewerlyRequestDTO) {
        Jewerly jewerly = modelMapper.map(jewerlyRequestDTO, Jewerly.class);
        jewerly.setIsOnSale(true);
        Jewerly jewerlySaved = jewerlyRepository.save(jewerly);
        return "Jewerly saved with id: " + jewerlySaved.getId();
    }
}
