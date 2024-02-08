package com.JPA.demo.service.interfaces;

import com.JPA.demo.dto.ClientDTO;
import com.JPA.demo.service.interfaces.generics.ICrudService;
import org.springframework.data.domain.Page;

public interface IClientService extends ICrudService<ClientDTO, Integer> {

    Page<ClientDTO> getAllEntities(int page, int size);

    ClientDTO findByEmail(String email);
}
