package com.example.qatesters.repository.interfaces;

import com.example.qatesters.dto.TestCaseDTO;
import com.example.qatesters.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseRepository extends JpaRepository <TestCase, Long>{
    List<TestCase> findByLastUpdateAfter(LocalDate last_update);
}
