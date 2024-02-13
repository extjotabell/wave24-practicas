package com.jpa.integrador.service;


import com.jpa.integrador.dto.request.SaleRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;

import com.jpa.integrador.dto.response.ClothesResponseDTO;
import com.jpa.integrador.dto.response.SaleListResponseDTO;
import com.jpa.integrador.dto.response.SaleResponseDTO;

import com.jpa.integrador.domain.Cloth;
import com.jpa.integrador.domain.Sale;
import com.jpa.integrador.repository.ISaleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SaleService implements ISaleService {

    ISaleRepository saleRepository;

    public SaleService(ISaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Boolean addSale(SaleRequestDTO saleRequestDTO) {
        Sale sale = new Sale(saleRequestDTO);
        saleRepository.save(sale);
        return true;
    }

    @Override
    public SaleListResponseDTO findAllSales() {
        Iterable<Sale> sales = saleRepository.findAll();
        List<Sale> salesList = new ArrayList<>();
        sales.forEach(salesList::add);
        List<SaleResponseDTO> salesResponse = salesList.stream().map(SaleResponseDTO::new).toList();
        return new SaleListResponseDTO(salesResponse);
    }

    @Override
    public SaleResponseDTO findOneSale(Integer id) {
        Sale sale = saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));
        return new SaleResponseDTO(sale);
    }

    @Override
    public Boolean updateSale(Integer code, SaleRequestDTO saleRequestDTO) {
        Sale sale = saleRepository.findById(code).orElseThrow(() -> new RuntimeException("Sale not found"));
        sale.setDate(saleRequestDTO.date());
        sale.setTotalAmount(saleRequestDTO.totalAmount());
        sale.setPaymentMethod(saleRequestDTO.paymentMethod());
        sale.setClothes(saleRequestDTO.clothes().stream().map(Cloth::new).collect(Collectors.toSet()));

        saleRepository.save(sale);
        return true;
    }

    @Override
    public Boolean deleteSale(Integer id) {
        saleRepository.deleteById(id);
        return true;
    }

    @Override
    public SaleListResponseDTO searchSaleByDate(LocalDate date) {
        List<Sale> sales = saleRepository.findSaleByDate(date);
        List<SaleResponseDTO> salesResponse = sales.stream().map(SaleResponseDTO::new).toList();
        return new SaleListResponseDTO(salesResponse);
    }

    @Override
    public ClothesListResponseDTO searchClothesBySaleId(Integer id) {
        Sale sale = saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));
        List<Cloth> clothes = sale.getClothes().stream().toList();
        List<ClothesResponseDTO> clothesResponse = clothes.stream().map(ClothesResponseDTO::new).toList();
        return new ClothesListResponseDTO(clothesResponse);
    }
}
