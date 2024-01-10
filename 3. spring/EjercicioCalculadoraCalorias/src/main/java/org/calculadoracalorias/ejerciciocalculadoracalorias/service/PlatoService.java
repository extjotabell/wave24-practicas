package org.calculadoracalorias.ejerciciocalculadoracalorias.service;

import org.calculadoracalorias.ejerciciocalculadoracalorias.dto.MenuDTO;
import org.calculadoracalorias.ejerciciocalculadoracalorias.entity.Comida;
import org.calculadoracalorias.ejerciciocalculadoracalorias.repository.IComidaRepository;
import org.calculadoracalorias.ejerciciocalculadoracalorias.repository.IPlatoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

@Service
public class PlatoService implements IPlatoService {

    private IPlatoRepository platoRepository;
    private IComidaRepository comidaRepository;

    public PlatoService(IPlatoRepository platoRepository, IComidaRepository comidaRepository) {
        this.platoRepository = platoRepository;
        this.comidaRepository = comidaRepository;
    }

    @Override
    public MenuDTO findByName(String name) {

        if (name.trim().isEmpty()) {
            return null;
        }

        ArrayList<Comida> comidas = new ArrayList<>();
        var ingredients = this.platoRepository.findByName(name).getIngredients();

        int totalCalories = ingredients.stream().mapToInt(ingredient->{
            var comida = this.comidaRepository.findByName(ingredient);
            comidas.add(comida);
            return comida.getCalories();
        }).sum();

        var listaIngredientes = ingredients.stream().map(ingredient -> this.comidaRepository.findByName(ingredient)).toList();
        Comida ingredientConMasCalorias = listaIngredientes
                .stream().max(Comparator.comparing(Comida::getCalories)).orElse(null);

        return new MenuDTO(ingredientConMasCalorias, comidas, totalCalories);
    }
}
