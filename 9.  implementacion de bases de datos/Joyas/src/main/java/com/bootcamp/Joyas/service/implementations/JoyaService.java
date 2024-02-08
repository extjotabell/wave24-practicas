package com.bootcamp.Joyas.service.implementations;

import com.bootcamp.Joyas.dto.JoyaDTO;
import com.bootcamp.Joyas.entity.Joya;
import com.bootcamp.Joyas.repository.IJoyaRepository;
import com.bootcamp.Joyas.service.interfaces.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class JoyaService implements IJoyaService {

    private IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    public Long createJewerly(JoyaDTO joyaDTO) {

        Joya joya = new Joya(
                joyaDTO.nombre(),
                joyaDTO.material(),
                joyaDTO.gramos(),
                joyaDTO.particularidad(),
                joyaDTO.posee_piedra(),
                joyaDTO.ventaONo()
        );

        return this.joyaRepository.save(joya).getId();
    }

    @Override
    public List<Joya> getAll() {
        return this.joyaRepository.findAllByVentaONo(true);
    }

    @Override
    public Long deleteJewerly(Long id) {
        Joya joya = this.joyaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Jewerly not found"));
        joya.setVentaONo(false);
        this.joyaRepository.save(joya);
        return id;
    }

    @Override
    public Joya updateJewerly(Long id_modificar, JoyaDTO joyaDTO) {
        Joya joya = this.joyaRepository.findById(id_modificar)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Jewerly not found"));
        joya.setNombre(joyaDTO.nombre());
        joya.setMaterial(joyaDTO.material());
        joya.setGramos(joyaDTO.gramos());
        joya.setParticularidad(joyaDTO.particularidad());
        joya.setPoseePiedra(joyaDTO.posee_piedra());
        joya.setVentaONo(joyaDTO.ventaONo());
        return this.joyaRepository.save(joya);
    }
}
