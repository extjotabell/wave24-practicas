package com.example.concesionaria.services;

import com.example.concesionaria.dto.AutoDTO;
import com.example.concesionaria.entity.Auto;
import com.example.concesionaria.exception.ParseException;
import com.example.concesionaria.repository.IAutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AutoService implements IAutoService {

    //comunicacion con repositorio
    @Autowired
    IAutoRepository autoRepository;


    @Override
    public List<AutoDTO> getAutos() {

        List<AutoDTO> result = new ArrayList<>();

        for (Auto auto : autoRepository.findAll()) {
            result.add(new AutoDTO(
                    auto.getId(),
                    auto.getBrand(),
                    auto.getModel(),
                    auto.getManufactoringDate(),
                    auto.getNumberOfKilometers(),
                    auto.getDoors(),
                    auto.getPrice(),
                    auto.getCurrency(),
                    auto.getCountOFOwners()));
        }

        return result;
    }

    @Override
    public Boolean crearAuto(Auto autos) {
        var rta = autoRepository.save(autos);
        if (rta != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<AutoDTO> getAutosbyDate(String date1, String date2) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<AutoDTO> result = new ArrayList<>();
        try {
            Date dat1 = dateFormat.parse(date1);
            Date dat2 = dateFormat.parse(date2);

            var autos = autoRepository.findByDate(dat1, dat2);
            for (Auto auto : autos) {
                result.add(new AutoDTO(
                        auto.getId(),
                        auto.getBrand(),
                        auto.getModel(),
                        auto.getManufactoringDate(),
                        auto.getNumberOfKilometers(),
                        auto.getDoors(),
                        auto.getPrice(),
                        auto.getCurrency(),
                        auto.getCountOFOwners()));
            }
            return result;
        }catch (ParseException | java.text.ParseException e) {
            throw new ParseException("Las fechas estan no se pudieron parsear ");
        }




    }

    @Override
    public List<AutoDTO> getAutosbyPrice(Double price1, Double price2) {
        return null;
    }


    @Override
    public AutoDTO getAuto(Integer id) {
        var auto = autoRepository.findById(id);
        System.out.println(auto);
        return auto.map(value -> new AutoDTO(
                value.getId(),
                value.getBrand(),
                value.getModel(),
                value.getManufactoringDate(),
                value.getNumberOfKilometers(),
                value.getDoors(),
                value.getPrice(),
                value.getCurrency(),
                value.getCountOFOwners())).orElse(null);
    }
}
