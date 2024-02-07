package com.practice.jewerly.mapper;

import com.practice.jewerly.dto.JewelDto;
import com.practice.jewerly.model.Jewel;

public class JewelMapper {
    public Jewel jewerlyDtoToJewerly(JewelDto jewelDto) {
        return new Jewel(
                jewelDto.nroIdentificatorio(),
                jewelDto.nombre(),
                jewelDto.material(),
                jewelDto.peso(),
                jewelDto.particularidad(),
                jewelDto.poseePiedra(),
                jewelDto.ventaONo()
        );
    }

    public JewelDto jewerlyToJewerlyDto(Jewel jewel) {
        return new JewelDto(
                jewel.getNroIdentificatorio(),
                jewel.getNombre(),
                jewel.getMaterial(),
                jewel.getPeso(),
                jewel.getParticularidad(),
                jewel.getPoseePiedra(),
                jewel.getVentaONo()
        );
    }
}
