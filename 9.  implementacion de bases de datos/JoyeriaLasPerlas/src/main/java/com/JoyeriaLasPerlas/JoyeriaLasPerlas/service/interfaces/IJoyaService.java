package com.JoyeriaLasPerlas.JoyeriaLasPerlas.service.interfaces;

import com.JoyeriaLasPerlas.JoyeriaLasPerlas.dto.JoyaDTO;
import com.JoyeriaLasPerlas.JoyeriaLasPerlas.service.interfaces.generics.ICrudService;

public interface IJoyaService extends ICrudService<JoyaDTO, Integer> {
    void eliminadoLogicoJoya(Integer id);

    JoyaDTO actualizarJoya(Integer id, JoyaDTO joyaDTO);
}
