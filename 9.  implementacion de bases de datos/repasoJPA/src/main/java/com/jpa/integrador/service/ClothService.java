package com.jpa.integrador.service;

import com.jpa.integrador.dto.request.ClothRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;
import com.jpa.integrador.dto.response.ClothesResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class ClothService implements IClothService{

    @Override
    public Boolean addCloth(ClothRequestDTO clothRequestDTO) {
        return null;
    }

    @Override
    public ClothesListResponseDTO findAllCloth() {
        return null;
    }

    @Override
    public ClothesResponseDTO findOneCloth(Integer id) {
        return null;
    }

    @Override
    public Boolean updateCloth(Integer code, ClothRequestDTO clothRequestDTO) {
        return null;
    }

    @Override
    public Boolean deleteCloth(Integer id) {
        return null;
    }

    @Override
    public ClothesListResponseDTO searchSaleBySize(String size) {
        return null;
    }

    @Override
    public ClothesListResponseDTO searchClothesByName(String name) {
        return null;
    }
}
