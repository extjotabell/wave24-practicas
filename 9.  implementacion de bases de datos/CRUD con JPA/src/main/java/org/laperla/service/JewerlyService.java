package org.laperla.service;

import org.laperla.dtos.JewerlyRequestDTO;
import org.springframework.stereotype.Service;

public interface JewerlyService {
    String newJewerly(JewerlyRequestDTO jewerlyRequestDTO);
}
