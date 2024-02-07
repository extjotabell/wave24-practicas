package com.mercadolibre.joyeriaexercise.service;

import com.mercadolibre.joyeriaexercise.dto.CreateJoyaResponseDTO;
import com.mercadolibre.joyeriaexercise.dto.JoyaDTO;
import com.mercadolibre.joyeriaexercise.entity.Joya;
import com.mercadolibre.joyeriaexercise.exception.NotFoundException;
import com.mercadolibre.joyeriaexercise.repository.IJoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaServiceImpl implements IJoyaService {
    private final IJoyaRepository joyaRepository;

    public JoyaServiceImpl(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public CreateJoyaResponseDTO createJoya(JoyaDTO joyaDTO) {
        Joya joyaToCreate = this.convertJoyaDTOtoJoyaEntity(joyaDTO);
        joyaToCreate = joyaRepository.save(joyaToCreate);
        return new CreateJoyaResponseDTO("Joya creada con éxito: NroIdentificatorio: " + joyaToCreate.getNroIdentificatorio().toString());
    }

    @Override
    public List<JoyaDTO> getAllJoya() {
        return joyaRepository.findByVentaONoIsTrue().stream().map(this::convertJoyaToJoyaDTO).toList();
    }

    @Override
    public JoyaDTO getJoya(Integer id) {
        return null;
    }

    @Override
    public JoyaDTO updateJoya(Long id, JoyaDTO joyaDTO) {
        Joya joyaToUpdate = convertJoyaDTOtoJoyaEntity(joyaDTO);
        joyaToUpdate.setNroIdentificatorio(id);

        joyaToUpdate = joyaRepository.save(joyaToUpdate);
        return convertJoyaToJoyaDTO(joyaToUpdate);
    }

    @Override
    public void deleteJoya(Integer id) {
        Joya joyaToDelete = joyaRepository.findById(id).orElseThrow(() -> new NotFoundException("Joya no encontrada"));
        joyaToDelete.setVentaONo(false);
        joyaRepository.save(joyaToDelete);
    }

    private JoyaDTO convertJoyaToJoyaDTO(Joya joya) {
        return new JoyaDTO(
                joya.getNroIdentificatorio(),
                joya.getNombre(),
                joya.getMaterial(),
                joya.getPeso(),
                joya.getParticularidad(),
                joya.getPoseePiedra(),
                joya.getVentaONo()
        );
    }

    private Joya convertJoyaDTOtoJoyaEntity(JoyaDTO joyaDTO) {
        return new Joya(
                joyaDTO.nroIdentificatorio(),
                joyaDTO.nombre(),
                joyaDTO.material(),
                joyaDTO.peso(),
                joyaDTO.particularidad(),
                joyaDTO.poseePiedra(),
                joyaDTO.ventaONo()
        );
    }
}
