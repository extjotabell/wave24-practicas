package com.ejercicio.calculadora_calorias.service;

import com.ejercicio.calculadora_calorias.dto.IngredientePlatoDTO;
import com.ejercicio.calculadora_calorias.dto.PlatoCaloriasDTO;
import com.ejercicio.calculadora_calorias.dto.PlatoMayorCaloriasDTO;
import com.ejercicio.calculadora_calorias.entity.Ingrediente;
import com.ejercicio.calculadora_calorias.entity.Plato;
import com.ejercicio.calculadora_calorias.repository.IngredienteRepository;
import com.ejercicio.calculadora_calorias.repository.PlatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PlatoService implements IPlatoService{

    private final PlatoRepository platoRepository;
    private final IngredienteRepository ingredienteRepository;

    private Plato getPlato(String name){
        Optional<Plato> optionalPlato = platoRepository.findByName(name);

        if(optionalPlato.isEmpty()){
            throw new RuntimeException("El plato no existe");
        }
        return optionalPlato.get();
    }

    @Override
    public PlatoCaloriasDTO getCaloriasPorPlato(String name){

        Plato plato = getPlato(name);

        Integer totalCalorias = plato.getIngredients().stream()
                .map(ingredienteRepository::findByName)
                .mapToInt(oi -> oi.map(Ingrediente::getCalories)
                        .orElse(0))
                .sum();

        return new PlatoCaloriasDTO(plato.getName(), totalCalorias);
    }

    @Override
    public IngredientePlatoDTO getIngredientesPorPlato(String name){
        Plato plato = getPlato(name);

        List<Ingrediente> ingredienteList = plato.getIngredients().stream()
                .map(ingredienteRepository::findByName)
                .filter(Optional::isPresent)
                .map(Optional::get).toList();

        return new IngredientePlatoDTO(ingredienteList);
    }

    @Override
    public PlatoMayorCaloriasDTO getMayorCalorias(String name){
        Plato plato = getPlato(name);

        Optional<Ingrediente> ingrediente = plato.getIngredients().stream()
                .map(ingredienteRepository::findByName)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList().stream()
                .max(Comparator.comparingInt(Ingrediente::getCalories));

        if(ingrediente.isEmpty()){
            throw new RuntimeException("El plato no tiene ingredientes");
        }
        return new PlatoMayorCaloriasDTO(ingrediente.get());
    }

}
