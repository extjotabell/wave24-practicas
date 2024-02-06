package org.miniseries.miniseries.repository;

import org.miniseries.miniseries.model.MiniSerieModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniserieRepository extends JpaRepository<MiniSerieModel, Long> {
}
