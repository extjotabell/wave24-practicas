package com.practice.testers.mapper;

import com.practice.testers.dto.TestCaseDTO;
import com.practice.testers.model.TestCase;

public class TestCaseMapper {
    public TestCaseDTO testCaseToTestCaseDTO(TestCase testCase) {
        return new TestCaseDTO(
                testCase.getIdCase(),
                testCase.getDescription(),
                testCase.getTested(),
                testCase.getPassed(),
                testCase.getNumberOfTries(),
                testCase.getLastUpdate()
        );
    }

    public TestCase testCaseDTOToTestCase(TestCaseDTO testCaseDTO) {
        return new TestCase(
                testCaseDTO.idCase(),
                testCaseDTO.description(),
                testCaseDTO.tested(),
                testCaseDTO.passed(),
                testCaseDTO.numberOfTries(),
                testCaseDTO.lastUpdate()
        );
    }
}
