package org.example.joyerialasperlas.service;

import org.example.joyerialasperlas.dto.JoyaDTO;
import org.example.joyerialasperlas.dto.MessageDTO;
import org.example.joyerialasperlas.entity.Joya;
import org.example.joyerialasperlas.repository.IJoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService{

    private final IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public JoyaDTO saveEntity(JoyaDTO joyaDTO) {
        Joya joya = new Joya(
                joyaDTO.nroIdentificatorio(),
                joyaDTO.nombre(),
                joyaDTO.material(),
                joyaDTO.peso(),
                joyaDTO.particularidad(),
                joyaDTO.poseePiedra(),
                joyaDTO.ventaONo()
        );
        joya = joyaRepository.save(joya);
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

    @Override
    public JoyaDTO getEntityById(Long id) {
        Joya joya = joyaRepository.findById(id).orElse(null);
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

    @Override
    public List<JoyaDTO> getAllEntities() {
        List<Joya> joyas = joyaRepository.findAll().stream().filter(joya -> joya.getVentaONo().equals(true)).toList();
        return joyas.stream().map(
                joya -> new JoyaDTO(
                        joya.getNroIdentificatorio(),
                        joya.getNombre(),
                        joya.getMaterial(),
                        joya.getPeso(),
                        joya.getParticularidad(),
                        joya.getPoseePiedra(),
                        joya.getVentaONo()
                )
        ).toList();
    }

    @Override
    public MessageDTO deleteEntity(Long id) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        joya.setVentaONo(false);
        joyaRepository.save(joya);
        return new MessageDTO("Joya eliminada.");
    }

    public JoyaDTO updateEntity(Long id, JoyaDTO joyaDTO) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        joya.setNombre(joyaDTO.nombre());
        joya.setMaterial(joyaDTO.material());
        joya.setPeso(joyaDTO.peso());
        joya.setParticularidad(joyaDTO.particularidad());
        joya.setPoseePiedra(joyaDTO.poseePiedra());
        joya.setVentaONo(joyaDTO.ventaONo());
        joyaDTO  = new JoyaDTO(
                joya.getNroIdentificatorio(),
                joya.getNombre(),
                joya.getMaterial(),
                joya.getPeso(),
                joya.getParticularidad(),
                joya.getPoseePiedra(),
                joya.getVentaONo()
        );

        this.saveEntity(joyaDTO);
        return joyaDTO;

    }
}
