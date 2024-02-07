package org.mercadolibre.co.lasperlas.service;

import org.mercadolibre.co.lasperlas.dto.JoyaDto;

import java.util.List;

public interface IJoyaService {

    JoyaDto createJoya(JoyaDto joyaDto);

    List<JoyaDto> getAllJoya();

    boolean deleteJoya(Long id);

    JoyaDto updateJoya(Long id, JoyaDto joyaDto);
}
