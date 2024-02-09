package com.jpa.integrador.service;

import com.jpa.integrador.dto.request.ClothRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;
import com.jpa.integrador.dto.response.ClothesResponseDTO;
import com.jpa.integrador.entity.Cloth;
import com.jpa.integrador.exception.NotFoundException;
import com.jpa.integrador.repository.IClothRepository;
import com.jpa.integrador.util.ClothMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClothService implements IClothService{
    private final IClothRepository clothRepository;

    public ClothService(IClothRepository clothRepository) {
        this.clothRepository = clothRepository;
    }

    @Override
    public Boolean addCloth(ClothRequestDTO clothRequestDTO) {
        Cloth clothCreated = clothRepository.save(ClothMapper.mapDTOToClothEntity(clothRequestDTO));
        if(clothCreated.getId() != null){
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public ClothesListResponseDTO findAllCloth() {
        List<Cloth> clothes = clothRepository.findAll();
        return new ClothesListResponseDTO(
                clothes.stream().map(ClothMapper::mapEntityToDTO).collect(Collectors.toList())
        );
    }

    @Override
    public ClothesResponseDTO findOneCloth(Integer id) {
        return ClothMapper.mapEntityToDTO(
                clothRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontro la prenda"))
        );
    }

    @Override
    public Boolean updateCloth(Integer code, ClothRequestDTO clothRequestDTO) {
        Cloth clothFind = clothRepository.findById(code).orElseThrow(() -> new NotFoundException("No se encontro la prenda"));

        Cloth clothToUpdate = ClothMapper.mapDTOToClothEntity(clothRequestDTO);
        clothToUpdate.setId(clothFind.getId());
        Cloth clothUpdated = this.clothRepository.save(clothToUpdate);

        if(clothUpdated.getId() != null){
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public Boolean deleteCloth(Integer id) {
        boolean existCloth = clothRepository.existsById(id);
        if(!existCloth){
            throw new NotFoundException("No se encontro la prenda");
        }

        this.clothRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public ClothesListResponseDTO searchSaleBySize(String size) {
        List<Cloth> clothesFind = clothRepository.findBySizeEquals(size);
        if(clothesFind.isEmpty()){
            throw new NotFoundException("No se encontro ninguna prenda con el talle ingresado");
        }

        return new ClothesListResponseDTO(
                clothesFind.stream().map(ClothMapper::mapEntityToDTO).collect(Collectors.toList())
        );
    }

    @Override
    public ClothesListResponseDTO searchClothesByName(String name) {
        List<Cloth> clothesFind = clothRepository.findByNameContainsIgnoreCase(name);
        if(clothesFind.isEmpty()){
            throw new NotFoundException("No se encontro ninguna prenda con el filtro ingresado");
        }

        return new ClothesListResponseDTO(
                clothesFind.stream().map(ClothMapper::mapEntityToDTO).collect(Collectors.toList())
        );
    }

}
