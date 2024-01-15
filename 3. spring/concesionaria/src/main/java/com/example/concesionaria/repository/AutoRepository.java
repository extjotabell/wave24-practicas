package com.example.concesionaria.repository;

import com.example.concesionaria.entity.Auto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class AutoRepository implements IAutoRepository{

    //lista para tener datos
    private List<Auto> autoList;

    //lista para almacenar autos
    public AutoRepository() {
        this.autoList = new ArrayList<Auto>();
    }
    @Override
    public Auto save(Auto auto) {this.autoList.add(auto); return auto;}

    @Override
    public Auto update(Auto auto) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }

    @Override
    public Optional<Auto> findById(Integer id) {
        return this.autoList.stream()
                .filter(auto-> auto.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Auto> findAll() {
        return this.autoList;
    }


    @Override
    public List<Auto> findByDate(Date dateFrom, Date  dateTo) {
        // Filtrar la lista de autos por rango de fechas
        return autoList.stream()
                .filter(auto -> {
                    Date autoDate = auto.getManufactoringDate();
                    return !autoDate.before(dateFrom) && !autoDate.after(dateTo);
                })
                .collect(Collectors.toList());
    }




    @Override
    public List<Auto> findByPrice(Double priceInit, Double priceFinal) {
        return autoList.stream()
                .filter(auto -> {
                    double autoPrice = auto.getPrice();
                    return autoPrice >= priceInit && autoPrice <= priceFinal;
                })
                .collect(Collectors.toList());
    }
}
