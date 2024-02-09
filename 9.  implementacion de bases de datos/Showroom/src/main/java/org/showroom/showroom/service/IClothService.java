package org.showroom.showroom.service;

import org.showroom.showroom.dto.request.ClothRequestDTO;
import org.showroom.showroom.dto.response.ClothesListResponseDTO;
import org.showroom.showroom.dto.response.ClothesResponseDTO;

public interface IClothService {

    Boolean addCloth(ClothRequestDTO clothRequestDTO);

    ClothesListResponseDTO findAllCloth();

    ClothesResponseDTO findOneCloth(String id);

    Boolean updateCloth(String code, ClothRequestDTO clothRequestDTO);

    Boolean deleteCloth(String id);

    ClothesListResponseDTO searchSaleBySize(String size);

    ClothesListResponseDTO searchClothesByName(String name);
}
