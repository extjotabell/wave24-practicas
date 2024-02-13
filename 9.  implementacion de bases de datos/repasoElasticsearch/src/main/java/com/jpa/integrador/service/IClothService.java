package com.jpa.integrador.service;

import com.jpa.integrador.dto.request.ClothRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;
import com.jpa.integrador.dto.response.ClothesResponseDTO;

public interface IClothService {

    Boolean addCloth(ClothRequestDTO clothRequestDTO);

    ClothesListResponseDTO findAllCloth();

    ClothesResponseDTO findOneCloth(Integer id);

    Boolean updateCloth(Integer code, ClothRequestDTO clothRequestDTO);

    Boolean deleteCloth(Integer id);

    ClothesListResponseDTO searchClothesBySize(String size);

    ClothesListResponseDTO searchClothesByName(String name);
}
