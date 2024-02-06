package com.JPA.demo.repository.interfaces;

import com.JPA.demo.dto.PersonDTO;
import com.JPA.demo.repository.interfaces.generics.ICrudService;

public interface IPersonService extends ICrudService<PersonDTO, Integer> {

}
