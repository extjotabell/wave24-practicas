package com.bootcamp.Joyas.service.interfaces;

import com.bootcamp.Joyas.dto.JoyaDTO;
import com.bootcamp.Joyas.entity.Joya;

import java.util.List;

public interface IJoyaService{
    Long createJewerly(JoyaDTO joyaDTO);
    List<Joya> getAll();

    Long deleteJewerly(Long id);

    Joya updateJewerly(Long id_modificar, JoyaDTO joyaDTO);
}
