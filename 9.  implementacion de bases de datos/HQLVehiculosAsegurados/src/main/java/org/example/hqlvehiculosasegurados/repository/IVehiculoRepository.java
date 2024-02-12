package org.example.hqlvehiculosasegurados.repository;

import org.example.hqlvehiculosasegurados.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    //Listar las patentes de todos los vehículos registrados.
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> getAllPatentes();

    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<Object[]> getPatenteMarcaVehiculosOrderByAnioFabricacion();
}
