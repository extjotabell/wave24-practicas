package com.jpa.integrador.service;

import com.jpa.integrador.dto.request.ClothRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;
import com.jpa.integrador.dto.response.ClothesResponseDTO;
import com.jpa.integrador.entity.Cloth;
import com.jpa.integrador.exception.NotFoundException;
import com.jpa.integrador.mapper.Mapper;
import com.jpa.integrador.repository.ClothRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothService implements IClothService{
    @Autowired
    ClothRepo clothRepo;
    @Override
    public Boolean addCloth(ClothRequestDTO clothRequestDTO) {
        Cloth cloth = Mapper.toCloth(clothRequestDTO);
        try {
            clothRepo.save(cloth);
        }
        catch (Exception e) {
            return false;
        }
        return true;

    }

    @Override
    public ClothesListResponseDTO findAllCloth() {
        List<Cloth> clothList = clothRepo.findAll();
        List<ClothesResponseDTO> clothesResponseDTOList = Mapper.toClothesResponseDTOList(clothList);
        return new ClothesListResponseDTO(clothesResponseDTOList);
        }

    @Override
    public ClothesResponseDTO findOneCloth(Integer id) {
        Cloth cloth = clothRepo.findById(id).orElseThrow(() -> new NotFoundException("No se encontro la prenda"));
        return Mapper.toClothesResponseDTO(cloth);
    }

    @Override
    public Boolean updateCloth(Integer code, ClothRequestDTO clothRequestDTO) {
        Cloth cloth = clothRepo.findById(code).orElseThrow(() -> new NotFoundException("No se encontro la prenda"));
        cloth.setName(clothRequestDTO.name());
        cloth.setBrand(clothRequestDTO.brand());
        cloth.setColor(clothRequestDTO.color());
        cloth.setSize(clothRequestDTO.size());
        cloth.setQuantity(clothRequestDTO.quantity());
        cloth.setSalePrice(clothRequestDTO.salePrice());
        try {
            clothRepo.save(cloth);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean deleteCloth(Integer id) {
        Cloth cloth = clothRepo.findById(id).orElseThrow(() -> new NotFoundException("No se encontro la prenda"));
        try {
            clothRepo.deleteById(id);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public ClothesListResponseDTO searchSaleBySize(String size) {
        List<Cloth> clothList = clothRepo.findBySize(size);
        List<ClothesResponseDTO> clothesResponseDTOList = Mapper.toClothesResponseDTOList(clothList);
        return new ClothesListResponseDTO(clothesResponseDTOList);
    }

    @Override
    public ClothesListResponseDTO searchClothesByName(String name) {
        System.out.println(name);
        List<Cloth> clothList = clothRepo.findByNameLike(name);
        List<ClothesResponseDTO> clothesResponseDTOList = Mapper.toClothesResponseDTOList(clothList);
        return new ClothesListResponseDTO(clothesResponseDTOList);
    }
}
