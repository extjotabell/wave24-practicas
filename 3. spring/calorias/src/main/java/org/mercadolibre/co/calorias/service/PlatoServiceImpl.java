package org.mercadolibre.co.calorias.service;

import org.mercadolibre.co.calorias.dto.IngredienteDTO;
import org.mercadolibre.co.calorias.dto.PlatoDTO;
import org.mercadolibre.co.calorias.entity.Ingrendiente;
import org.mercadolibre.co.calorias.repository.IIngredienteRespository;
import org.mercadolibre.co.calorias.repository.IPlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class PlatoServiceImpl implements IPlatoService{

    @Autowired
    private IPlatoRepository platoRepository;

    @Autowired
    private IIngredienteRespository ingredienteRespository;

    @Override
    public List<PlatoDTO> getCaloriasPlatos(String[] platos) {

        List<PlatoDTO> platoDTOS = new ArrayList<>();

        for (String plato: platos) {
            var platoAux = platoRepository.findByName(plato);
           if (platoAux != null) {
               int calorias = 0;
            for(String ingrediente: platoAux.getIngredients()) {
               var ingredienteAux = ingredienteRespository.findByName(ingrediente);
                if (ingredienteAux != null) {
                     calorias += ingredienteAux.getCalories();
                }
            }
            platoDTOS.add(new PlatoDTO(platoAux.getName(), calorias));
           }
        }

        return platoDTOS;
    }

    @Override
    public List<IngredienteDTO> getIngredientes(String[] platos) {

        List<IngredienteDTO> ingredienteDTOS = new ArrayList<>();

for (String plato: platos) {
            var platoAux = platoRepository.findByName(plato);
            if (platoAux != null) {
                for(String ingrediente: platoAux.getIngredients()) {
                    var ingredienteAux = ingredienteRespository.findByName(ingrediente);
                    if (ingredienteAux != null) {
                        ingredienteDTOS.add(new IngredienteDTO(ingredienteAux.getName(), ingredienteAux.getCalories()));
                    }
                }
            }
        }

        return ingredienteDTOS;
    }

    @Override
    public List<IngredienteDTO> getIngredienteMayor(String[] platos) {

        List<IngredienteDTO> ingredienteDTOS = new ArrayList<>();

        for (String plato: platos) {
            var platoAux = platoRepository.findByName(plato);
            String ingredienteMayor = "";
            int caloriasMayor = 0;
            for(String ingrediente: platoAux.getIngredients()) {
                var ingredienteAux = ingredienteRespository.findByName(ingrediente);
                if (ingredienteAux != null) {
                    if (ingredienteAux.getCalories() > caloriasMayor) {
                        ingredienteMayor = ingredienteAux.getName();
                        caloriasMayor = ingredienteAux.getCalories();
                    }
                }
            }
            if(!ingredienteMayor.isEmpty())
                ingredienteDTOS.add(new IngredienteDTO(ingredienteMayor, caloriasMayor));
        }



        return ingredienteDTOS;
    }
}
