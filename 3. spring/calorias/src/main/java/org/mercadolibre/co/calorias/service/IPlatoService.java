package org.mercadolibre.co.calorias.service;

import org.mercadolibre.co.calorias.dto.IngredienteDTO;
import org.mercadolibre.co.calorias.dto.PlatoDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPlatoService {

    List<PlatoDTO> getCaloriasPlatos(String[] platos);

    List<IngredienteDTO> getIngredientes(String[] platos);

    List<IngredienteDTO> getIngredienteMayor(String[] platos);

}
