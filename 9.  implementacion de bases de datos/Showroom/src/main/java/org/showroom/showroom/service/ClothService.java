package org.showroom.showroom.service;

import org.showroom.showroom.domain.Cloth;
import org.showroom.showroom.dto.request.ClothRequestDTO;
import org.showroom.showroom.dto.response.ClothesListResponseDTO;
import org.showroom.showroom.dto.response.ClothesResponseDTO;
import org.showroom.showroom.repository.IClothRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClothService implements IClothService{
    IClothRepository clothRepository;

    public ClothService(IClothRepository clothRepository) {
        this.clothRepository = clothRepository;
    }

    @Override
    public Boolean addCloth(ClothRequestDTO clothRequestDTO) {
        Cloth cloth = new Cloth(
                clothRequestDTO.id(),
                clothRequestDTO.name(),
                clothRequestDTO.brand(),
                clothRequestDTO.color(),
                clothRequestDTO.size(),
                clothRequestDTO.quantity(),
                clothRequestDTO.salePrice()
        );
        clothRepository.save(cloth);
        return true;
    }

    @Override
    public ClothesListResponseDTO findAllCloth() {
        Iterable<Cloth> list = clothRepository.findAll();
        return transformList(list);
    }

    @Override
    public ClothesResponseDTO findOneCloth(String id) {
        Cloth cloth = clothRepository.findById(id).orElseThrow();
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
    public Boolean updateCloth(String code, ClothRequestDTO clothRequestDTO) {
        Cloth cloth = clothRepository.findById(code).orElseThrow();
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
    public Boolean deleteCloth(String id) {
        Cloth cloth = clothRepository.findById(id).orElseThrow();
        clothRepository.delete(cloth);
        return true;
    }

    @Override
    public ClothesListResponseDTO searchSaleBySize(String size) {
        List<Cloth> list = clothRepository.findBySizeEquals(size);
        return transformList(list);
    }

    @Override
    public ClothesListResponseDTO searchClothesByName(String name) {
        List<Cloth> list = clothRepository.findByNameContaining(name);
        return transformList(list);
    }
    private ClothesListResponseDTO transformList(Iterable<Cloth> list){
        List<ClothesResponseDTO> clothesDTO = new ArrayList<>();
        list.forEach(cloth ->
                clothesDTO
                        .add(
                                new ClothesResponseDTO(
                                        cloth.getId(),
                                        cloth.getName(),
                                        cloth.getBrand(),
                                        cloth.getColor(),
                                        cloth.getSize(),
                                        cloth.getQuantity(),
                                        cloth.getSalePrice()
                                )
                        )
        );
        return new ClothesListResponseDTO(clothesDTO);
    }
}
