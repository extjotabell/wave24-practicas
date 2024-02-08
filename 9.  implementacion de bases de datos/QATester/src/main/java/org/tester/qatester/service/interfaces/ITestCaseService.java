package org.tester.qatester.service.interfaces;

import org.tester.qatester.dto.TestCaseDTO;
import org.tester.qatester.service.generics.ICrudService;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService extends ICrudService<TestCaseDTO, Long> {
    List<TestCaseDTO> findByLastUpdateAfter(LocalDate date);
}
