package org.tester.qatester.service.implement;

import org.springframework.stereotype.Service;
import org.tester.qatester.dto.MessageDTO;
import org.tester.qatester.dto.TestCaseDTO;
import org.tester.qatester.entity.TestCase;
import org.tester.qatester.repository.ITestCaseRepository;
import org.tester.qatester.service.interfaces.ITestCaseService;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {

    ITestCaseRepository testCaseRepository;

    public TestCaseService(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public TestCaseDTO save(TestCaseDTO testCaseDTO) {
        TestCase testCase = convertToTestCase(testCaseDTO);
        testCase = testCaseRepository.save(testCase);
        if (testCase == null) {
            return null;
        }
        return convertToTesCaseDTO(testCase);
    }

    @Override
    public TestCaseDTO update(TestCaseDTO testCaseDTO, Long id) {

        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        if (testCase == null) {
            return null;
        }
        TestCase testCaseToUpdate = convertToTestCase(testCaseDTO);
        testCase.setDescription(testCaseToUpdate.getDescription());
        testCase.setTested(testCaseToUpdate.getTested());
        testCase.setPassed(testCaseToUpdate.getPassed());
        testCase.setNumberOfTries(testCaseToUpdate.getNumberOfTries());
        testCase.setLastUpdate(testCaseToUpdate.getLastUpdate());
        testCase = testCaseRepository.save(testCase);
        return convertToTesCaseDTO(testCase);
    }

    @Override
    public TestCaseDTO findById(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        if (testCase == null) {
            return null;
        }
        return convertToTesCaseDTO(testCase);
    }

    @Override
    public List<TestCaseDTO> findAll() {
        List<TestCase> testCases = testCaseRepository.findAll();
        if (testCases.isEmpty()) {
            return null;
        }
        return testCases.stream().map(this::convertToTesCaseDTO).toList();
    }

    @Override
    public MessageDTO delete(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        if (testCase == null) {
            return null;
        }
        testCaseRepository.delete(testCase);
        return new MessageDTO("Test Case deleted", "200");
    }
    public List<TestCaseDTO> findByLastUpdateAfter(LocalDate date) {
        List<TestCase> testCases = testCaseRepository.findByLastUpdateAfter(date);
        if (testCases.isEmpty()) {
            return null;
        }
        return testCases.stream().map(this::convertToTesCaseDTO).toList();
    }

    private TestCaseDTO convertToTesCaseDTO(TestCase testCase) {
        TestCaseDTO testCaseDTO = new TestCaseDTO(
            testCase.getIdCase(),
            testCase.getDescription(),
            testCase.getTested(),
            testCase.getPassed(),
            testCase.getNumberOfTries(),
            testCase.getLastUpdate()
        );
        return testCaseDTO;
    }
    private TestCase convertToTestCase(TestCaseDTO testCaseDTO) {
        TestCase testCase = new TestCase(
            testCaseDTO.idCase(),
            testCaseDTO.description(),
            testCaseDTO.tested(),
            testCaseDTO.passed(),
            testCaseDTO.numberOfTries(),
            testCaseDTO.lastUpdate()
        );
        return testCase;
    }
}
