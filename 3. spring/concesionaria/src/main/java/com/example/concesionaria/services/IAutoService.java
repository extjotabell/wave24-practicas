package com.example.concesionaria.services;

import com.example.concesionaria.dto.AutoDTO;
import com.example.concesionaria.entity.Auto;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface IAutoService {

    List<AutoDTO> getAutos(); //mostrar autos sin sus servicios
    Boolean crearAuto(Auto autos); //
    List<AutoDTO> getAutosbyDate(String  date1, String  date2);
    List<AutoDTO> getAutosbyPrice(Double price1, Double price2);
    AutoDTO getAuto(Integer id);
}
