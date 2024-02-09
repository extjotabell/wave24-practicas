package org.mercadolibre.co.lasperlas.service;

import org.mercadolibre.co.lasperlas.dto.JoyaDto;
import org.mercadolibre.co.lasperlas.dto.JoyaResponseDTO;

import java.util.List;

public interface IJoyaService {

    JoyaDto createJoya(JoyaDto joyaDto);


    List<JoyaResponseDTO> getAllJewerly();

    Boolean deleteJewerly(Long id);

    Boolean updateJewerly(Long id, JoyaDto joyaDto);
}
