package com.example.configurandojpa.service;

import com.example.configurandojpa.model.MiniSerie;
import com.example.configurandojpa.repository.IMiniSerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiniSerieServiceImp implements IMiniSerieService{
    private final IMiniSerieRepository miniSerieRepository;

    public MiniSerieServiceImp(IMiniSerieRepository miniSerieRepository) {
        this.miniSerieRepository = miniSerieRepository;
    }

    @Override
    public List<MiniSerie> findAll(){

        return  miniSerieRepository.findAll();
    }
    @Override
    public MiniSerie findById(Long id){
       return miniSerieRepository.findById(id).orElseThrow(()->new RuntimeException("NO SE ENCUENTRA"));
    }

    @Override
    public MiniSerie create(MiniSerie miniSerie) {
        return miniSerieRepository.save(miniSerie);
    }
}
