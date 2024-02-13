package com.example.configurandojpa.service;


import com.example.configurandojpa.model.MiniSerie;

import java.util.List;

public interface IMiniSerieService {
    List<MiniSerie> findAll();
    MiniSerie findById(Long id);
    MiniSerie create(MiniSerie miniSerie);
}
