package org.calculadoracalorias.ejerciciocalculadoracalorias.service;

import org.calculadoracalorias.ejerciciocalculadoracalorias.dto.MenuDTO;

import java.util.ArrayList;

public interface IPlatoService {

    MenuDTO findByName(String name);
}
