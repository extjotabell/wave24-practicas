package com.JPA.demo.repository.interfaces;

import com.JPA.demo.dto.ClientDTO;
import com.JPA.demo.repository.interfaces.generics.ICrudService;

public interface IClientService extends ICrudService<ClientDTO, Integer> {
}
