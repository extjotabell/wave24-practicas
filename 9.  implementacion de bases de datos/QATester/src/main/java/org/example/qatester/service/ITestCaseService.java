package org.example.qatester.service;

import org.example.qatester.dto.ResponseDto;
import org.example.qatester.dto.TestCaseDto;
import org.example.qatester.entity.TestCase;

import java.util.List;

public interface ITestCaseService {
    TestCaseDto saveTestCase(TestCaseDto testCase);

    List<TestCaseDto> getAllTestCase();

    TestCaseDto getTestCaseById(Long id);

    TestCaseDto updateTestCase(Long id, TestCaseDto testCaseDto);

    ResponseDto deleteTestCaseById(Long id);


}
