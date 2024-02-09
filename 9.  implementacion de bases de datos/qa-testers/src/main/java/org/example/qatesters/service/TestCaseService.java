package org.example.qatesters.service;

import org.example.qatesters.model.TestCase;
import org.example.qatesters.repository.ITestCaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {

    private ITestCaseRepository testCaseRepository;

    public TestCaseService(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public TestCase addTestCase(TestCase testCase) {
        return testCaseRepository.save(testCase);
    }

    @Override
    public List<TestCase> findAllTestCases() {
        return testCaseRepository.findAll();
    }

    @Override
    public TestCase findOneTestCase(Long id) {
        return testCaseRepository.findById(id).orElseThrow(() -> new RuntimeException("Test case not found"));
    }

    @Override
    public TestCase updateTestCase(Long id, TestCase testCase) {
        TestCase existingTestCase = testCaseRepository.findById(id).orElseThrow(() -> new RuntimeException("Test case not found"));
        existingTestCase.setDescription(testCase.getDescription());
        existingTestCase.setTested(testCase.getTested());
        existingTestCase.setPassed(testCase.getPassed());
        existingTestCase.setAttempts(testCase.getAttempts());
        existingTestCase.setLastUpdated(testCase.getLastUpdated());

        return testCaseRepository.save(existingTestCase);
    }

    @Override
    public Boolean deleteTestCase(Long id) {
        if (!testCaseRepository.existsById(id)) {
            return false;
        }

        testCaseRepository.deleteById(id);
        return true;
    }

    @Override
    public List<TestCase> searchTestCasesByDate(LocalDate date) {
        return testCaseRepository.findByLastUpdated(date);
    }
}
