package com.practice.testers.service;

import com.practice.testers.dto.MessageDTO;
import com.practice.testers.dto.TestCaseDTO;
import com.practice.testers.mapper.TestCaseMapper;
import com.practice.testers.model.TestCase;
import com.practice.testers.repository.ITestCaseRepository;
import com.practice.testers.service.interfaces.ITestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {
    private final ITestCaseRepository testCaseRepository;
    private final TestCaseMapper testCaseMapper;

    private final String NOT_FOUND;
    public TestCaseService(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
        this.testCaseMapper = new TestCaseMapper();
        this.NOT_FOUND = "test not found";
    }

    @Override
    public MessageDTO save(TestCaseDTO testCaseDTO) {
        TestCase testCase = testCaseMapper.testCaseDTOToTestCase(testCaseDTO);
        testCase = testCaseRepository.save(testCase);

        return new MessageDTO(
                HttpStatus.OK,
                "test created",
                List.of(testCaseMapper.testCaseToTestCaseDTO(testCase))
        );
    }

    @Override
    public MessageDTO getById(Long id) {
        if (!testCaseRepository.existsById(id))
            return new MessageDTO(
                    HttpStatus.NOT_FOUND,
                    NOT_FOUND,
                    List.of()
            );

        TestCase testCase = testCaseRepository.findById(id).orElseThrow();

        return new MessageDTO(
                HttpStatus.OK,
                NOT_FOUND,
                List.of(testCaseMapper.testCaseToTestCaseDTO(testCase))
        );
    }

    @Override
    public MessageDTO getAll() {
        return new MessageDTO(
                HttpStatus.OK,
                "test cases found",
                testCaseRepository.findAll().stream().map(
                        testCaseMapper::testCaseToTestCaseDTO
                ).toList()
        );
    }

    @Override
    public MessageDTO deleteById(Long id) {
        if (!testCaseRepository.existsById(id))
            return new MessageDTO(
                    HttpStatus.NOT_FOUND,
                    NOT_FOUND,
                    List.of()
            );

        testCaseRepository.deleteById(id);
        return new MessageDTO(
                HttpStatus.OK,
                "test deleted",
                List.of()
        );
    }

    @Override
    public MessageDTO updateById(Long id, TestCaseDTO testCaseDTO) {
        if (!testCaseRepository.existsById(id))
            return new MessageDTO(
                    HttpStatus.NOT_FOUND,
                    NOT_FOUND,
                    List.of()
            );

        TestCase testCase = testCaseMapper.testCaseDTOToTestCase(testCaseDTO);
        testCase.setIdCase(id);
        testCase = testCaseRepository.save(testCase);

        return new MessageDTO(
                HttpStatus.OK,
                "test updated",
                List.of(testCaseMapper.testCaseToTestCaseDTO(testCase))
        );
    }
}
