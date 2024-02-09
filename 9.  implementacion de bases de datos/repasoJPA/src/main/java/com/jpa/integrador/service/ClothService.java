package com.jpa.integrador.service;

import com.jpa.integrador.dto.request.ClothRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;
import com.jpa.integrador.dto.response.ClothesResponseDTO;
import com.jpa.integrador.entity.Cloth;
import com.jpa.integrador.exception.BadRequestException;
import com.jpa.integrador.exception.NotFoundException;
import com.jpa.integrador.mapper.ClothMapper;
import com.jpa.integrador.repository.IClothRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothService implements IClothService{
    private final IClothRepository clothRepository;
    private final ClothMapper clothMapper;

    public ClothService(IClothRepository clothRepository) {
        this.clothRepository = clothRepository;
        this.clothMapper = new ClothMapper();
    }

    @Override
    public Boolean addCloth(ClothRequestDTO clothRequestDTO) {
        if (clothRequestDTO.id()!=null && clothRepository.existsById(clothRequestDTO.id()))
            throw new BadRequestException("El id " +  clothRequestDTO.id() + " ya existe");

        Cloth cloth = clothMapper.clothRequestDtoToClothEntity(clothRequestDTO);
        cloth = clothRepository.save(cloth);

        return clothRepository.existsById(cloth.getId());
    }

    @Override
    public ClothesListResponseDTO findAllCloth() {
        return new ClothesListResponseDTO(
                clothRepository.findAll().stream().map(
                        clothMapper::clothEntityToClothResponseDto
                ).toList()
        );
    }

    @Override
    public ClothesResponseDTO findOneCloth(Integer id) {
        Cloth cloth = clothRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontró la prenda " + id));
        return clothMapper.clothEntityToClothResponseDto(cloth);
    }

    @Override
    public Boolean updateCloth(Integer code, ClothRequestDTO clothRequestDTO) {
        if (!clothRepository.existsById(code))
            throw new NotFoundException("No se encontró la prenda " + code);

        Cloth cloth = clothMapper.clothRequestDtoToClothEntity(clothRequestDTO);
        cloth.setId(code);
        clothRepository.save(cloth);

        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteCloth(Integer id) {
        if (!clothRepository.existsById(id))
            throw new NotFoundException("No se encontró la prenda " + id);

        clothRepository.deleteById(id);

        return Boolean.TRUE;
    }

    @Override
    public ClothesListResponseDTO searchSaleBySize(String size) {
        List<Cloth> clothes = clothRepository.findBySizeEquals(size);

        return new ClothesListResponseDTO(
                clothes.stream().map(
                    clothMapper::clothEntityToClothResponseDto
                ).toList()
        );
    }

    @Override
    public ClothesListResponseDTO searchClothesByName(String name) {
        List<Cloth> clothes = clothRepository.findByNameContainsIgnoreCase(name);

        return new ClothesListResponseDTO(
                clothes.stream().map(
                        clothMapper::clothEntityToClothResponseDto
                ).toList()
        );
    }
}
