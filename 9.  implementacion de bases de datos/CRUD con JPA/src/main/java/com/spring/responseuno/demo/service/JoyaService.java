package com.spring.responseuno.demo.service;

import com.spring.responseuno.demo.model.Joya;
import com.spring.responseuno.demo.repository.IJoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class JoyaService implements IJoyaService{

    @Autowired
    IJoyaRepository joyaRepo;

    public String saveJoya(Joya joya) {
        joyaRepo.save(joya);

        return "Joya guardada correctamente";
    }

    public List<Joya> getJoyas() {

        return joyaRepo.findAll();
    }

    public Joya findJoya ( Long id){
        //el orElse nos permite devolver null en caso que no encuentre
        return joyaRepo.findById(id).orElse(null);
    }

    public String deleteJoya(Long id){
        Optional<Joya> joya = joyaRepo.findById(id);
           joyaRepo.deleteById(id);
        return "Joya eliminada correctamente";

    }

    @Override
    public String editJoya(Long id_modificar, Joya joya_modif) {
        joyaRepo.save(joya_modif);
        return "Joya modificada correctamente";
    }


}
