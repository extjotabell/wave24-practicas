package com.example.calculadoracalorias.services;

import com.example.calculadoracalorias.dtos.PlatoConMayorCalorias;
import com.example.calculadoracalorias.dtos.IngredientesPorPlato;
import com.example.calculadoracalorias.dtos.CaloriasPorPlato;
import com.example.calculadoracalorias.entities.Ingrediente;
import com.example.calculadoracalorias.entities.Plato;
import com.example.calculadoracalorias.repositories.IngredenteRepository;
import com.example.calculadoracalorias.repositories.PlatoRepository;
import com.example.calculadoracalorias.services.interfaces.PlatoServiceInt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlatoServiceImp implements PlatoServiceInt {

    private final PlatoRepository platoRepository;
    private final IngredenteRepository ingredenteRepository;

    @Override
    public CaloriasPorPlato getCaloriesByPlato(String name) throws RuntimeException{
        Plato plato = getPlato(name);

        Integer totalCalories = plato.getIngredients().stream()
                .map(ingredenteRepository::findByName)
                .mapToInt(optionalIngrediente ->
                    optionalIngrediente.map(Ingrediente::getCalories).orElse(0)
                ).sum();

        return new CaloriasPorPlato(plato.getName(), totalCalories);
    }

    @Override
    public IngredientesPorPlato getIngredientePorPlato(String name) throws RuntimeException {
        Plato plato = getPlato(name);

        List<Ingrediente> ingredienteList = plato.getIngredients().stream()
                .map(ingredenteRepository::findByName)
                .filter(Optional::isPresent)
                .map(Optional::get).toList();

        return new IngredientesPorPlato(ingredienteList);
    }

    @Override
    public PlatoConMayorCalorias getHighestCalorie(String name) throws RuntimeException{
        Plato plato = getPlato(name);

        Optional<Ingrediente> ingrediente = plato.getIngredients().stream()
                .map(ingredenteRepository::findByName)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList().stream()
                .max(Comparator.comparingInt(Ingrediente::getCalories));

        if(ingrediente.isEmpty()){
            throw new RuntimeException("El plato no tiene ingredientes");
        }

        return new PlatoConMayorCalorias(ingrediente.get());
    }


    private Plato getPlato(String name) throws RuntimeException {
        Optional<Plato> optionalPlato = platoRepository.findByName(name);

        if(optionalPlato.isEmpty()){
            throw new RuntimeException("El plato no existe");
        }
        return optionalPlato.get();
    }
}
