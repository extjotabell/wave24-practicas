package com.jpa.integrador.service;


import com.jpa.integrador.dto.request.SaleRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;

import com.jpa.integrador.dto.response.SaleListResponseDTO;
import com.jpa.integrador.dto.response.SaleResponseDTO;

import com.jpa.integrador.entity.Sale;
import com.jpa.integrador.exception.NotFoundException;
import com.jpa.integrador.repository.ISaleRepository;
import com.jpa.integrador.util.ClothMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SaleService implements ISaleService {

    private ISaleRepository saleRepository;

    public SaleService(ISaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Boolean addSale(SaleRequestDTO saleRequestDTO) {
        Sale saleCreated = saleRepository.save(this.convertToEntity(saleRequestDTO));
        if(saleCreated.getId() != null){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public SaleListResponseDTO findAllSales() {
        List<Sale> sales = saleRepository.findAll();
        return new SaleListResponseDTO(
                sales.stream().map(this::convertToDTO).collect(Collectors.toList())
        );
    }

    @Override
    public SaleResponseDTO findOneSale(Integer id) {
        Sale saleFind = saleRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontro la venta"));
        return this.convertToDTO(saleFind);
    }

    @Override
    public Boolean updateSale(Integer code, SaleRequestDTO saleRequestDTO) {
        Sale saleFind = saleRepository.findById(code).orElseThrow(() -> new NotFoundException("No se encontro la venta"));
        Sale saleToUpdate = this.convertToEntity(saleRequestDTO);
        saleToUpdate.setId(saleFind.getId());
        Sale saleUpdated = saleRepository.save(saleToUpdate);
        if(saleUpdated.getId() != null){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean deleteSale(Integer id) {
        this.saleRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public SaleListResponseDTO searchSaleByDate(LocalDate date) {
        return null;
    }

    @Override
    public ClothesListResponseDTO searchClothesBySaleId(Integer id) {
        Sale saleFind = saleRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontro la venta"));
        return new ClothesListResponseDTO(
                saleFind.getClothes().stream().map(ClothMapper::mapEntityToDTO).collect(Collectors.toList())
        );
    }

    private Sale convertToEntity(SaleRequestDTO saleRequestDTO){
        return new Sale(
                saleRequestDTO.id(),
            saleRequestDTO.date(),
            saleRequestDTO.totalAmount(),
            saleRequestDTO.paymentMethod(),
            saleRequestDTO.cloth().stream().map(ClothMapper::mapDTOToClothEntity).collect(Collectors.toList())
        );
    }

    private SaleResponseDTO convertToDTO(Sale sale){
        return new SaleResponseDTO(
                sale.getId(),
                sale.getDate(),
                sale.getTotalAmount(),
                sale.getPaymentMethod(),
                sale.getClothes().stream().map(ClothMapper::mapEntityToDTO).collect(Collectors.toList())
        );
    }
}
