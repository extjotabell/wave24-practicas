package org.example.hqlvehiculosasegurados.repository;

import org.example.hqlvehiculosasegurados.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos
    @Query("SELECT s.vehiculo.patente, s.vehiculo.marca, s.vehiculo.modelo FROM Siniestro s WHERE s.perdidaEconomica > 10000")
    List<Object[]> getVehiculoSiniestroPerdida();

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos
    @Query("SELECT s.vehiculo.patente, s.vehiculo.marca, s.vehiculo.modelo, SUM(s.perdidaEconomica) FROM Siniestro s WHERE s.perdidaEconomica > 10000 GROUP BY s.vehiculo.patente, s.vehiculo.marca, s.vehiculo.modelo")
    List<Object[]> getVehiculosSiniestroPerdidaTotal();
}
