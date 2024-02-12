package org.example.qatester.mapper;

import org.example.qatester.dto.TestCaseDto;
import org.example.qatester.entity.TestCase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {
    public TestCase convertDtoToTestCase(TestCaseDto testCaseDto){
        return new TestCase(
                testCaseDto.idCase(),
                testCaseDto.description(),
                testCaseDto.tested(),
                testCaseDto.passed(),
                testCaseDto.numberOfTries(),
                testCaseDto.lastUpdate()
        );
    }

    public TestCaseDto convertTestCaseToDto(TestCase testCase){
        return new TestCaseDto(
                testCase.getIdCase(),
                testCase.getDescription(),
                testCase.getTested(),
                testCase.getPassed(),
                testCase.getNumberOfTries(),
                testCase.getLastUpdate()
        );
    }

    public List<TestCaseDto> convertListToListDto(List<TestCase> testCaseList){
        return testCaseList.stream()
                .map(this::convertTestCaseToDto)
                .collect(Collectors.toList());
    }
}
