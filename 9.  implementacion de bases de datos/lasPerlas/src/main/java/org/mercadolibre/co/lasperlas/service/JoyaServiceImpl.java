package org.mercadolibre.co.lasperlas.service;

import org.mercadolibre.co.lasperlas.dto.JoyaDto;
import org.mercadolibre.co.lasperlas.dto.JoyaResponseDTO;
import org.mercadolibre.co.lasperlas.entity.Joya;
import org.mercadolibre.co.lasperlas.repository.IJoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaServiceImpl implements IJoyaService {

    @Autowired
    private IJoyaRepository joyaRepository;

    @Override
    public JoyaDto createJoya(JoyaDto joyaDto) {

        //request dpt to entoty : id null lo crea, si existe lo actualiza
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
    public List<JoyaResponseDTO> getAllJewerly() {
        List<JoyaResponseDTO> joyaDtolist = joyaRepository.findAll().stream()
                .filter(joya -> joya.isVentaONo() ==false)
                .map(joya ->
                new JoyaResponseDTO(
                joya.getId(),
                joya.getNombre(),
                joya.getMaterial(),
                joya.getPeso(),
                joya.getParticularidad(),
                joya.isPoseePiedra(),
                joya.isVentaONo())).toList();


        return joyaDtolist;
    }

    @Override
    public Boolean deleteJewerly(Long id) {
         var joya = joyaRepository.findById(id).orElseThrow();

         if (joya.isVentaONo()) { //true
             return false;
         }
         joya.setVentaONo(true);
         joyaRepository.save(joya);

         return true;
    }

    @Override
    public Boolean updateJewerly(Long id, JoyaDto joyaDto) {
        var joya = joyaRepository.findById(id).orElseThrow();

        joya.setNombre(joyaDto.nombre());
        joya.setMaterial(joyaDto.material());
        joya.setPeso(joyaDto.peso());
        joya.setParticularidad(joyaDto.particularidad());
        joya.setPoseePiedra(joyaDto.poseePiedra());
        joya.setVentaONo(joyaDto.ventaONo());
        joyaRepository.save(joya);
        return true;


    }


}
