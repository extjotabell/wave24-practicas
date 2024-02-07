package org.jewerly.lasperlas.service.generics;

import org.jewerly.lasperlas.dto.MessageDTO;
import org.jewerly.lasperlas.dto.response.JewerlyUpdateResponseDTO;

import java.util.List;

public interface ICrudService<T, ID> {
    MessageDTO saveEntity(T personDTO);

    JewerlyUpdateResponseDTO updateEntityById(T jewerlyDTO, Long id);

    List<T> getAllEntities();

    MessageDTO deleteEntity(ID id);
}
