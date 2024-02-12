package org.example.qatester.service;

import org.example.qatester.dto.ResponseDto;
import org.example.qatester.dto.TestCaseDto;
import org.example.qatester.entity.TestCase;
import org.example.qatester.mapper.Mapper;
import org.example.qatester.repository.ITestCaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService{

    private final ITestCaseRepository testCaseRepository;

    private final Mapper mapper;


    public TestCaseService(ITestCaseRepository testCaseRepository, Mapper mapper) {
        this.testCaseRepository = testCaseRepository;
        this.mapper = mapper;
    }

    @Override
    public TestCaseDto saveTestCase(TestCaseDto testCaseDto) {
        TestCase testCase = mapper.convertDtoToTestCase(testCaseDto);
        return mapper.convertTestCaseToDto(testCaseRepository.save(testCase));
    }

    @Override
    public List<TestCaseDto> getAllTestCase() {
        return mapper.convertListToListDto(testCaseRepository.findAll());
    }

    @Override
    public TestCaseDto getTestCaseById(Long id) {
        return mapper.convertTestCaseToDto(testCaseRepository.findById(id).orElseThrow());
    }

    @Override
    public TestCaseDto updateTestCase(Long id, TestCaseDto testCaseDto) {
        TestCase testCase = mapper.convertDtoToTestCase(getTestCaseById(id));
        testCase.setIdCase(testCaseDto.idCase());
        testCase.setDescription(testCaseDto.description());
        testCase.setTested(testCaseDto.tested());
        testCase.setPassed(testCaseDto.passed());
        testCase.setNumberOfTries(testCaseDto.numberOfTries());
        testCase.setLastUpdate(testCaseDto.lastUpdate());
        return mapper.convertTestCaseToDto(testCaseRepository.save(testCase));
    }

    @Override
    public ResponseDto deleteTestCaseById(Long id) {
        testCaseRepository.delete(mapper.convertDtoToTestCase(getTestCaseById(id)));
        return new ResponseDto("Caso de prueba eliminado");
    }

    public List<TestCaseDto> findTestCaseUpdatedAfterDate(LocalDate date){
        return mapper.convertListToListDto(testCaseRepository.findByLastUpdateAfter(date));
    }

    /*
    public List<TestCaseDto> findTestCaseUpdatedAfterDate(LocalDate date){
        List<TestCase> testCaseList = testCaseRepository.findAll().stream()
                .filter(testCase -> testCase.getLastUpdate().isAfter(date)).toList();
        return mapper.convertListToListDto(testCaseList);
    }
     */
}
