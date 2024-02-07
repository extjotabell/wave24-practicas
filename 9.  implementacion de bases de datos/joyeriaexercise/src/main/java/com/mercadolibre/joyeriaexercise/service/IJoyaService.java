package com.mercadolibre.joyeriaexercise.service;

import com.mercadolibre.joyeriaexercise.dto.CreateJoyaResponseDTO;
import com.mercadolibre.joyeriaexercise.dto.JoyaDTO;

import java.util.List;

public interface IJoyaService {
    CreateJoyaResponseDTO createJoya(JoyaDTO joyaDTO);
    List<JoyaDTO> getAllJoya();
    JoyaDTO getJoya(Integer id);
    JoyaDTO updateJoya(Long id, JoyaDTO joyaDTO);
    void deleteJoya(Integer id);

}
