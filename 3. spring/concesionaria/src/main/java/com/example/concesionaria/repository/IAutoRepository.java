package com.example.concesionaria.repository;

import com.example.concesionaria.entity.Auto;

import java.util.Date;
import java.util.List;

public interface IAutoRepository extends ICrudRepository<Auto>{

    List<Auto> findByDate(Date dateFrom , Date  dateTo);


    List<Auto> findByPrice(Double priceInit , Double priceFinal);
}
