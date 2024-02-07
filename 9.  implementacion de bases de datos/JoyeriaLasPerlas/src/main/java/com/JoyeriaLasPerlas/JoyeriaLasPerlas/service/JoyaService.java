package com.JoyeriaLasPerlas.JoyeriaLasPerlas.service;

import com.JoyeriaLasPerlas.JoyeriaLasPerlas.dto.JoyaDTO;
import com.JoyeriaLasPerlas.JoyeriaLasPerlas.dto.MessageDTO;
import com.JoyeriaLasPerlas.JoyeriaLasPerlas.entity.Joya;
import com.JoyeriaLasPerlas.JoyeriaLasPerlas.exceptions.NotFoundException;
import com.JoyeriaLasPerlas.JoyeriaLasPerlas.repository.interfaces.IJoyaRepository;
import com.JoyeriaLasPerlas.JoyeriaLasPerlas.service.interfaces.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService {

    @Autowired
    IJoyaRepository joyaRepository;
    @Override
    public List<JoyaDTO> getAllEntities() {
        List<Joya> joyas = joyaRepository.findAll();

        return joyas.stream()
                .filter(joya -> joya.getVentaONo())
                .map(joya -> new JoyaDTO(
                        joya.getNro_identificatorio(),
                        joya.getNombre(),
                        joya.getMaterial(),
                        joya.getPeso(),
                        joya.getParticularidad(),
                        joya.getPosee_piedra(),
                        joya.getVentaONo()
                )
        ).toList();
    }

    @Override
    public JoyaDTO saveEntity(JoyaDTO joyaDto) {
        Joya joya = new Joya(
                joyaDto.id(),
                joyaDto.nombre(),
                joyaDto.material(),
                joyaDto.peso(),
                joyaDto.particularidad(),
                joyaDto.posee_piedra(),
                joyaDto.ventaONo()
        );

        joya = joyaRepository.save(joya);

        return new JoyaDTO(
                joya.getNro_identificatorio(),
                joya.getNombre(),
                joya.getMaterial(),
                joya.getPeso(),
                joya.getParticularidad(),
                joya.getPosee_piedra(),
                joya.getVentaONo()
        );
    }

    public void eliminadoLogicoJoya(Integer id){
        Joya joya = joyaRepository.findById(id).orElseThrow(() -> new NotFoundException("Joya no encontrada con ID: " + id));
        joya.setVentaONo(false);
        joyaRepository.save(joya);
    }

    public JoyaDTO actualizarJoya(Integer id, JoyaDTO joyaDTO) {
        Joya joyaExistente = joyaRepository.findById(id).orElseThrow(() -> new NotFoundException("Joya no encontrada con ID: " + id));

        joyaExistente.setNombre(joyaDTO.nombre());
        joyaExistente.setMaterial(joyaDTO.material());
        joyaExistente.setPeso(joyaDTO.peso());
        joyaExistente.setParticularidad(joyaDTO.particularidad());
        joyaExistente.setPosee_piedra(joyaDTO.posee_piedra());
        joyaExistente.setVentaONo(joyaDTO.ventaONo());

        Joya joyaActualizada = joyaRepository.save(joyaExistente);

        return new JoyaDTO(
                joyaActualizada.getNro_identificatorio(),
                joyaActualizada.getNombre(),
                joyaActualizada.getMaterial(),
                joyaActualizada.getPeso(),
                joyaActualizada.getParticularidad(),
                joyaActualizada.getPosee_piedra(),
                joyaActualizada.getVentaONo()
        );
    }

    @Override
    public JoyaDTO getEntityById(Integer integer) {
        return null;
    }

    @Override
    public MessageDTO deleteEntity(Integer integer) {
        return null;
    }
}
