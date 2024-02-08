package org.example.joyerialasperlas.service;

import org.example.joyerialasperlas.dto.JoyaDTO;
import org.example.joyerialasperlas.dto.MessageDTO;

import java.util.List;

public interface IJoyaService{
    JoyaDTO saveEntity(JoyaDTO joyaDTO);

    JoyaDTO getEntityById(Long id);

    List<JoyaDTO> getAllEntities();

    MessageDTO deleteEntity(Long id);
}
