package org.example.hqlvehiculosasegurados.repository;

import org.example.hqlvehiculosasegurados.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
}
