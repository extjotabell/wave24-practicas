package com.jpa.integrador.service;

import com.jpa.integrador.dto.request.ClothRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;
import com.jpa.integrador.dto.response.ClothesResponseDTO;
import com.jpa.integrador.entity.Cloth;
import com.jpa.integrador.exception.DBConnectionException;
import com.jpa.integrador.exception.NotFoundException;
import com.jpa.integrador.repository.IClothRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ClothService implements IClothService{
    private final IClothRepository clothRepository;

    @Override
    public Boolean addCloth(ClothRequestDTO clothRequestDTO) {
        try {
            clothRepository.save(clothRequestDTO.dtoToClothInStorage());
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private Stream<Cloth> iterableToStream(Iterable<Cloth> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }

    @Override
    public ClothesListResponseDTO findAllCloth() {
        return new ClothesListResponseDTO(
                iterableToStream(clothRepository.findAll()).map(ClothesResponseDTO::of).toList()
        );
    }

    @Override
    public ClothesResponseDTO findOneCloth(Integer id) {
        var clothFound = clothRepository.findById(id.toString());

        if (clothFound.isEmpty())
            throw new DBConnectionException("The cloth you are looking for does not exist");

        return ClothesResponseDTO.of(clothFound.get());
    }

    @Override
    public Boolean updateCloth(Integer code, ClothRequestDTO clothRequestDTO) {
        var clothToUpdate = clothRepository.findById(code.toString());

        if (clothToUpdate.isEmpty())
            return false;

        clothRepository.save(clothRequestDTO.assign(clothToUpdate.get()));

        return true;
    }

    @Override
    public Boolean deleteCloth(Integer id) {
        try {
            clothRepository.deleteById(id.toString());
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public ClothesListResponseDTO searchSaleBySize(String size) {
        var clothesFound = clothRepository.findBySize(size);

        if (clothesFound.isEmpty())
            throw new NotFoundException("No se encontraron prendas de la talla " + size + ".");

        return new ClothesListResponseDTO(clothesFound.stream().map(ClothesResponseDTO::of).toList());
    }

    @Override
    public ClothesListResponseDTO searchClothesByName(String name) {
        var clothesFound = clothRepository.findByNameContaining(name);

        if (clothesFound.isEmpty())
            throw new NotFoundException("No se encontraron prendas con el nombre " + name + ".");

        return new ClothesListResponseDTO(clothesFound.stream().map(ClothesResponseDTO::of).toList());
    }
}
