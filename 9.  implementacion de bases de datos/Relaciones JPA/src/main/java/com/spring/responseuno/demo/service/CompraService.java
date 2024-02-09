package com.spring.responseuno.demo.service;

import com.spring.responseuno.demo.model.Compra;
import com.spring.responseuno.demo.repository.ICompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    ICompraRepository compraRepo;

    public String saveCompra(Compra compra) {
        compraRepo.save(compra);

        return "Compra guardada correctamente";
    }
}
