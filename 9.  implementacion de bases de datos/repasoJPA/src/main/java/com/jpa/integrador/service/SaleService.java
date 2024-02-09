package com.jpa.integrador.service;


import com.jpa.integrador.dto.request.SaleRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;

import com.jpa.integrador.dto.response.SaleListResponseDTO;
import com.jpa.integrador.dto.response.SaleResponseDTO;

import com.jpa.integrador.entity.Sale;
import com.jpa.integrador.exception.BadRequestException;
import com.jpa.integrador.exception.NotFoundException;
import com.jpa.integrador.mapper.ClothMapper;
import com.jpa.integrador.mapper.SaleMapper;
import com.jpa.integrador.repository.ISaleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class SaleService implements ISaleService {
    private final ISaleRepository saleRepository;
    private final SaleMapper saleMapper;
    private final ClothMapper clothMapper;

    public SaleService(ISaleRepository saleRepository) {
        this.saleRepository = saleRepository;
        this.saleMapper = new SaleMapper();
        this.clothMapper = new ClothMapper();
    }

    @Override
    public Boolean addSale(SaleRequestDTO saleRequestDTO) {
        if (saleRequestDTO.id()!=null && saleRepository.existsById(saleRequestDTO.id()))
            throw new BadRequestException("El id " +  saleRequestDTO.id() + " ya existe");

        Sale sale = saleMapper.saleRequestDtoToSaleEntity(saleRequestDTO);
        sale = saleRepository.save(sale);

        return saleRepository.existsById(sale.getId());
    }

    @Override
    public SaleListResponseDTO findAllSales() {
        return new SaleListResponseDTO(
                saleRepository.findAll().stream().map(
                        saleMapper::saleEntityToSaleResponseDTO
                ).toList()
        );
    }

    @Override
    public SaleResponseDTO findOneSale(Integer id) {
        Sale sale = saleRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontró la venta " + id));
        return saleMapper.saleEntityToSaleResponseDTO(sale);
    }

    @Override
    public Boolean updateSale(Integer code, SaleRequestDTO saleRequestDTO) {
        if (!saleRepository.existsById(code))
            throw new NotFoundException("No se encontró la venta " + code);

        Sale sale = saleMapper.saleRequestDtoToSaleEntity(saleRequestDTO);
        sale.setId(code);
        saleRepository.save(sale);

        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteSale(Integer id) {
        if (!saleRepository.existsById(id))
            throw new NotFoundException("No se encontró la venta " + id);

        saleRepository.deleteById(id);

        return Boolean.TRUE;
    }

    @Override
    public SaleListResponseDTO searchSaleByDate(LocalDate date) {
        List<Sale> sales = saleRepository.findByDateEquals(date);

        return new SaleListResponseDTO(
                sales.stream().map(
                        saleMapper::saleEntityToSaleResponseDTO
                ).toList()
        );
    }

    @Override
    public ClothesListResponseDTO searchClothesBySaleId(Integer id) {
        Sale sale = saleRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontró la venta " + id));

        return new ClothesListResponseDTO(
                sale.getClothes().stream().map(
                        clothMapper::clothEntityToClothResponseDto
                ).toList()
        );
    }
}
