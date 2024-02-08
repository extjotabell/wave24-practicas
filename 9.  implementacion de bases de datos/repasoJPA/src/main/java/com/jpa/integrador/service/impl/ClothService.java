package com.jpa.integrador.service.impl;

import com.jpa.integrador.dto.request.ClothRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;
import com.jpa.integrador.dto.response.ClothesResponseDTO;
import com.jpa.integrador.entity.Cloth;
import com.jpa.integrador.repository.IClothRespository;
import com.jpa.integrador.service.interfaces.IClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothService implements IClothService {

    @Autowired
    IClothRespository clothRepository;

    @Override
    public Boolean addCloth(ClothRequestDTO clothRequestDTO) {
        Cloth cloth = mapToCloth(clothRequestDTO);
        clothRepository.save(cloth);
        return true;
    }

    @Override
    public ClothesListResponseDTO findAllCloth() {
        List<Cloth> clothList = clothRepository.findAll();
        return getClothesListResponseDTO(clothList);
    }

    @Override
    public ClothesResponseDTO findOneCloth(Integer id) {
        Cloth cloth = getClothById(id);
        return mapToClothesResponseDTO(cloth);
    }

    @Override
    public Boolean updateCloth(Integer code, ClothRequestDTO clothRequestDTO) {
        if (!clothRepository.existsById(code))
            return false;
        Cloth clothSaved = mapToCloth(clothRequestDTO);
        clothSaved.setId(code);
        clothRepository.save(clothSaved);
        return true;
    }

    @Override
    public Boolean deleteCloth(Integer id) {
        if (!clothRepository.existsById(id))
            return false;
        clothRepository.deleteById(id);
        return true;
    }

    @Override
    public ClothesListResponseDTO searchSaleBySize(String size) {
        List<Cloth> clothesFound = clothRepository.findClothBySize(size);
        if (clothesFound.isEmpty())
            throw new RuntimeException("There are no items in that size");
        return getClothesListResponseDTO(clothesFound);
    }

    @Override
    public ClothesListResponseDTO searchClothesByName(String name) {
        List<Cloth> clothesFound = clothRepository.findByNameContains(name);
        if (clothesFound.isEmpty())
            throw new RuntimeException("There are no garments with that name");
        return getClothesListResponseDTO(clothesFound);
    }

    private Cloth mapToCloth(ClothRequestDTO clothRequestDTO) {
        Cloth cloth = new Cloth();
        cloth.setId(clothRequestDTO.id());
        cloth.setName(clothRequestDTO.name());
        cloth.setBrand(clothRequestDTO.brand());
        cloth.setColor(clothRequestDTO.color());
        cloth.setSize(clothRequestDTO.size());
        cloth.setQuantity(clothRequestDTO.quantity());
        cloth.setSalePrice(clothRequestDTO.salePrice());
        return cloth;
    }

    private ClothesListResponseDTO getClothesListResponseDTO(List<Cloth> clothList) {
        return new ClothesListResponseDTO(clothList.stream()
                .map(this::mapToClothesResponseDTO)
                .toList());
    }

    private ClothesResponseDTO mapToClothesResponseDTO(Cloth cloth) {
        return new ClothesResponseDTO(
                cloth.getId(),
                cloth.getName(),
                cloth.getBrand(),
                cloth.getColor(),
                cloth.getSize(),
                cloth.getQuantity(),
                cloth.getSalePrice()
        );
    }

    private Cloth getClothById(Integer id) {
        return clothRepository.findById(id).orElseThrow(
                () -> new RuntimeException("The cloth with id:" + id + " was not found in the database")
        );
    }
}