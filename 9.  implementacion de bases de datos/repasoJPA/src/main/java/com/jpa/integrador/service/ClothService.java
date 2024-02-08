package com.jpa.integrador.service;

import com.jpa.integrador.dto.request.ClothRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;
import com.jpa.integrador.dto.response.ClothesResponseDTO;
import com.jpa.integrador.entity.Cloth;
import com.jpa.integrador.repository.IClothRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClothService implements IClothService{

    private final IClothRepository clothRepository;

    @Override
    public Boolean addCloth(ClothRequestDTO clothRequestDTO) {

        Cloth cloth = clothRequestDTOToCloth(clothRequestDTO);
        clothRepository.save(cloth);
        return true;

    }

    private Cloth clothRequestDTOToCloth(ClothRequestDTO clothRequestDTO){
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

    @Override
    public ClothesListResponseDTO findAllCloth() {

        List<Cloth> clothList = clothRepository.findAll();
        return getClothesListResponseDTO(clothList);
    }

    private static ClothesListResponseDTO getClothesListResponseDTO(List<Cloth> clothList) {
        return new ClothesListResponseDTO(clothList.stream().map(cloth -> new ClothesResponseDTO(
                cloth.getId(),
                cloth.getName(),
                cloth.getBrand(),
                cloth.getColor(),
                cloth.getSize(),
                cloth.getQuantity(),
                cloth.getSalePrice()
        )).toList());
    }

    @Override
    public ClothesResponseDTO findOneCloth(Integer id) {
        Cloth cloth = clothRepository.findById(id).orElseThrow(
            () -> new RuntimeException("No se encontro la prenda")
        );
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

    @Override
    public Boolean updateCloth(Integer code, ClothRequestDTO clothRequestDTO) {

        if(!clothRepository.existsById(code))
            return false;

        Cloth clothSaved = clothRequestDTOToCloth(clothRequestDTO);
        clothSaved.setId(code);
        clothRepository.save(clothSaved);
        return true;

    }


    @Override
    public Boolean deleteCloth(Integer id) {

        if(!clothRepository.existsById(id))
            return false;

        clothRepository.deleteById(id);
        return true;
    }

    @Override
    public ClothesListResponseDTO searchSaleBySize(String size) {

        List<Cloth> clothesFound = clothRepository.findClothBySize(size);
        if (clothesFound.isEmpty())
            throw new RuntimeException("No existen prendas en ese talle");

        return getClothesListResponseDTO(clothesFound);

    }

    @Override
    public ClothesListResponseDTO searchClothesByName(String name) {
        List<Cloth> clothesFound = clothRepository.findByNameContains(name);
        if (clothesFound.isEmpty())
            throw new RuntimeException("No existen prendas con ese nombre");

        return getClothesListResponseDTO(clothesFound);
    }
}
