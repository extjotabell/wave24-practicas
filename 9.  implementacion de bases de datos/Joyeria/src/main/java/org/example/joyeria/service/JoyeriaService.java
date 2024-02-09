package org.example.joyeria.service;

import org.example.joyeria.dto.JoyaDTO;
import org.example.joyeria.dto.JoyaPostResponseDTO;
import org.example.joyeria.model.Joya;
import org.example.joyeria.repository.JoyeriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class JoyeriaService {
    private final JoyeriaRepository joyeriaRepository;

    public JoyeriaService(JoyeriaRepository joyeriaRepository) {
        this.joyeriaRepository = joyeriaRepository;
    }


    public List<JoyaDTO> getJoyeria() {
        List<Joya> joyas = joyeriaRepository.findAll();
        return joyas
                .stream()
                .filter(Joya::getVentaONo)
                .map(
                        joya -> new JoyaDTO(joya.getNombre(), joya.getMaterial(), joya.getPeso(), joya.getParticularidad(), joya.getPoseePiedra(), joya.getVentaONo())).toList();
    }

    public JoyaPostResponseDTO addJoya(JoyaDTO joyaDTO) {
        Joya joya = new Joya(joyaDTO.nombre(), joyaDTO.material(), joyaDTO.peso(), joyaDTO.particularidad(), joyaDTO.posee_piedra(), true);
        Joya newJoya = joyeriaRepository.save(joya);
        return new JoyaPostResponseDTO(newJoya.getNroIdentificatorio());
    }

    public void deleteJoya(Long id) {
        Optional<Joya> joya = joyeriaRepository.findById(id);

        if(joya.isEmpty()){
            throw new RuntimeException("No existe la joya");
        }
        joya.get().setVentaONo(false);
    }

    public JoyaDTO updateJoya(Long id, JoyaDTO joyaDTO) {
        Optional<Joya> joya = joyeriaRepository.findById(id);

        if(joya.isEmpty()){
            throw new RuntimeException("No existe la joya");
        }
        joya.get().setNombre(joyaDTO.nombre());
        joya.get().setMaterial(joyaDTO.material());
        joya.get().setPeso(joyaDTO.peso());
        joya.get().setParticularidad(joyaDTO.particularidad());
        joya.get().setPoseePiedra(joyaDTO.posee_piedra());
        joya.get().setVentaONo(joyaDTO.ventaONo());
        return new JoyaDTO(joya.get().getNombre(), joya.get().getMaterial(), joya.get().getPeso(), joya.get().getParticularidad(), joya.get().getPoseePiedra(), joya.get().getVentaONo());
    }
}
