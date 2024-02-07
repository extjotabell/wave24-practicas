package org.mercadolibre.co.lasperlas.service;

import org.apache.catalina.User;
import org.mercadolibre.co.lasperlas.dto.JoyaDto;
import org.mercadolibre.co.lasperlas.entity.Joya;
import org.mercadolibre.co.lasperlas.exception.NotFoundException;
import org.mercadolibre.co.lasperlas.repository.IJoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaServiceImpl implements IJoyaService{

    @Autowired
    private IJoyaRepository joyaRepository;

    @Override
    public JoyaDto createJoya(JoyaDto joyaDto) {


        var jovaSave = joyaRepository.save(new Joya(
                null,
                joyaDto.nombre(),
                joyaDto.material(),
                joyaDto.peso(),
                joyaDto.particularidad(),
                joyaDto.poseePiedra(),
                joyaDto.ventaONo(),
                false
        ));

        return new JoyaDto(
                jovaSave.getNombre(),
                jovaSave.getMaterial(),
                jovaSave.getPeso(),
                jovaSave.getParticularidad(),
                jovaSave.isPoseePiedra(),
                jovaSave.isVentaONo()
        );
    }

    @Override
    public List<JoyaDto> getAllJoya() {

        var joyas = joyaRepository.findByEliminadoFalse();

        return joyas.stream().map(joya -> new JoyaDto(
                joya.getNombre(),
                joya.getMaterial(),
                joya.getPeso(),
                joya.getParticularidad(),
                joya.isPoseePiedra(),
                joya.isVentaONo()
        )).toList();
    }

    @Override
    public boolean deleteJoya(Long id) {
        Joya joya = joyaRepository.findById(id).orElseThrow(() -> new NotFoundException("Joya not found"));

        joya.setEliminado(true);

        joyaRepository.save(joya);

        return true;
    }

    @Override
    public JoyaDto updateJoya(Long id, JoyaDto joyaDto) {

        Joya joya = joyaRepository.findById(id).orElseThrow(() -> new NotFoundException("Joya not found"));

        joya.setNombre(joyaDto.nombre());
        joya.setMaterial(joyaDto.material());
        joya.setPeso(joyaDto.peso());
        joya.setParticularidad(joyaDto.particularidad());
        joya.setPoseePiedra(joyaDto.poseePiedra());
        joya.setVentaONo(joyaDto.ventaONo());

        joyaRepository.save(joya);

        return new JoyaDto(
                joya.getNombre(),
                joya.getMaterial(),
                joya.getPeso(),
                joya.getParticularidad(),
                joya.isPoseePiedra(),
                joya.isVentaONo()
        );
    }
}
