package com.jpa.integrador.service;

import com.jpa.integrador.dto.request.ClothRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;
import com.jpa.integrador.dto.response.ClothesResponseDTO;
import com.jpa.integrador.domain.Cloth;
import com.jpa.integrador.repository.IClothRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClothService implements IClothService {

    private IClothRepository clothRepository;

    public ClothService(IClothRepository clothRepository) {
        this.clothRepository = clothRepository;
    }

    @Override
    public Boolean addCloth(ClothRequestDTO clothRequestDTO) {
        Cloth cloth = new Cloth(clothRequestDTO);
        clothRepository.save(cloth);
        return true;
    }

    @Override
    public ClothesListResponseDTO findAllCloth() {
        Iterable<Cloth> clothes = clothRepository.findAll();
        List<Cloth> clothesList = new ArrayList<>();
        clothes.forEach(clothesList::add);
        List<ClothesResponseDTO> clothesResponse = clothesList.stream().map(ClothesResponseDTO::new).toList();
        return new ClothesListResponseDTO(clothesResponse);
    }

    @Override
    public ClothesResponseDTO findOneCloth(Integer id) {
        Cloth cloth = clothRepository.findById(id).orElseThrow(() -> new RuntimeException("Cloth not found"));
        return new ClothesResponseDTO(cloth);
    }

    @Override
    public Boolean updateCloth(Integer code, ClothRequestDTO clothRequestDTO) {
        Cloth cloth = clothRepository.findById(code).orElseThrow(() -> new RuntimeException("Cloth not found"));
        cloth.setName(clothRequestDTO.name());
        cloth.setBrand(clothRequestDTO.brand());
        cloth.setColor(clothRequestDTO.color());
        cloth.setSize(clothRequestDTO.size());
        cloth.setQuantity(clothRequestDTO.quantity());
        cloth.setSalePrice(clothRequestDTO.salePrice());

        clothRepository.save(cloth);
        return true;
    }

    @Override
    public Boolean deleteCloth(Integer id) {
        clothRepository.deleteById(id);
        return true;
    }

    @Override
    public ClothesListResponseDTO searchClothesBySize(String size) {
        List<Cloth> clothes = clothRepository.findClothsBySizeEquals(size);
        List<ClothesResponseDTO> clothesResponse = clothes.stream().map(ClothesResponseDTO::new).toList();
        return new ClothesListResponseDTO(clothesResponse);
    }

    @Override
    public ClothesListResponseDTO searchClothesByName(String name) {
        List<Cloth> clothes = clothRepository.findClothsByNameLike("%" + name + "%");
        List<ClothesResponseDTO> clothesResponse = clothes.stream().map(ClothesResponseDTO::new).toList();
        return new ClothesListResponseDTO(clothesResponse);
    }
}
