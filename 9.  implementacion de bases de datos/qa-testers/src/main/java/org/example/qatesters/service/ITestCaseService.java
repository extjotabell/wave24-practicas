package org.example.qatesters.service;

import org.example.qatesters.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCase addTestCase(TestCase testCase);
    List<TestCase> findAllTestCases();
    TestCase findOneTestCase(Long id);
    TestCase updateTestCase(Long id, TestCase testCase);
    Boolean deleteTestCase(Long id);
    List<TestCase> searchTestCasesByDate(LocalDate date);
}
