package com.jpa.integrador.service;


import com.jpa.integrador.dto.request.SaleRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;

import com.jpa.integrador.dto.response.SaleListResponseDTO;
import com.jpa.integrador.dto.response.SaleResponseDTO;

import com.jpa.integrador.entity.Cloth;
import com.jpa.integrador.entity.Sale;
import com.jpa.integrador.exception.NotFoundException;
import com.jpa.integrador.mapper.Mapper;
import com.jpa.integrador.repository.SaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class SaleService implements ISaleService {

    @Autowired
    SaleRepo saleRepo;
    @Override
    public Boolean addSale(SaleRequestDTO saleRequestDTO) {
        Sale sale = Mapper.toSale(saleRequestDTO);
        try {
            saleRepo.save(sale);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public SaleListResponseDTO findAllSales() {
        return Mapper.toSaleListResponseDTO(saleRepo.findAll());
    }

    @Override
    public SaleResponseDTO findOneSale(Integer id) {
        Sale sale=saleRepo.findById(id).orElseThrow(() -> new NotFoundException("No se encontro la venta"));
        return Mapper.toSaleResponseDTO(sale);
    }

    @Override
    public Boolean updateSale(Integer code, SaleRequestDTO saleRequestDTO) {
        Sale saleToUpdate = saleRepo.findById(code).orElseThrow(() -> new NotFoundException("No se encontro la venta"));
        saleToUpdate.setDate(saleRequestDTO.date());
        saleToUpdate.setTotalAmount(saleRequestDTO.totalAmount());
        saleToUpdate.setPaymentMethod(saleRequestDTO.paymentMethod());
        saleToUpdate.setClothList(Mapper.toClothList(saleRequestDTO.clothList()));
        try {
            saleRepo.save(saleToUpdate);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean deleteSale(Integer id) {
        Sale sale = saleRepo.findById(id).orElseThrow(() -> new NotFoundException("No se encontro la venta"));
        try {
            saleRepo.deleteById(id);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public SaleListResponseDTO searchSaleByDate(LocalDate date) {
        return Mapper.toSaleListResponseDTO(saleRepo.findByDateEquals(date));
    }

    @Override
    public ClothesListResponseDTO searchClothesBySaleId(Integer id) {
        return new ClothesListResponseDTO( Mapper.toListOfClothesResponseDTO(saleRepo.searchListClothes(id)));
    }
}
