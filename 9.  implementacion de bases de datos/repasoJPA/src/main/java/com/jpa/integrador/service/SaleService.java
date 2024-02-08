package com.jpa.integrador.service;


import com.jpa.integrador.dto.request.SaleRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;

import com.jpa.integrador.dto.response.SaleListResponseDTO;
import com.jpa.integrador.dto.response.SaleResponseDTO;

import com.jpa.integrador.repository.ISaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class SaleService implements ISaleService {

    private final ISaleRepository saleRepository;

    @Override
    public Boolean addSale(SaleRequestDTO saleRequestDTO) {


    }



    @Override
    public SaleListResponseDTO findAllSales() {
        return null;
    }

    @Override
    public SaleResponseDTO findOneSale(Integer id) {
        return null;
    }

    @Override
    public Boolean updateSale(Integer code, SaleRequestDTO saleRequestDTO) {
        return null;
    }

    @Override
    public Boolean deleteSale(Integer id) {
        return null;
    }

    @Override
    public SaleListResponseDTO searchSaleByDate(LocalDate date) {
        return null;
    }

    @Override
    public ClothesListResponseDTO searchClothesBySaleId(Integer id) {
        return null;
    }
}
