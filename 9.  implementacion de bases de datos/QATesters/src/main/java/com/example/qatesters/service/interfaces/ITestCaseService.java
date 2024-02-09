package com.example.qatesters.service.interfaces;

import com.example.qatesters.dto.TestCaseDTO;
import com.example.qatesters.entity.TestCase;
import com.example.qatesters.service.interfaces.generics.ICrudService;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService extends ICrudService<TestCaseDTO, Long> {
    TestCaseDTO saveUpdate(Long id, TestCaseDTO testCaseDTO);
    List<TestCaseDTO> getTestCasesUpdatedAfterDate(LocalDate last_update);
}
