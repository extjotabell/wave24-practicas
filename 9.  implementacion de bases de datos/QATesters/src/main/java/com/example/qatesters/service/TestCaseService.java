package com.example.qatesters.service;

import com.example.qatesters.dto.MessageDTO;
import com.example.qatesters.dto.TestCaseDTO;
import com.example.qatesters.dto.UpdatedTestRespondeDTO;
import com.example.qatesters.entity.TestCase;
import com.example.qatesters.exceptions.NotFoundException;
import com.example.qatesters.repository.interfaces.ITestCaseRepository;
import com.example.qatesters.service.interfaces.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService {

    @Autowired
    private ITestCaseRepository testCaseRepository;


    @Override
    public TestCaseDTO saveEntity(TestCaseDTO testCaseDTO) {
        TestCase testCase = new TestCase(
                testCaseDTO.id_case(),
                testCaseDTO.description(),
                testCaseDTO.tested(),
                testCaseDTO.passed(),
                testCaseDTO.number_of_tries(),
                testCaseDTO.last_update()
        );

        testCase = testCaseRepository.save(testCase);

        return new TestCaseDTO(
                testCase.getId_case(),
                testCase.getDescription(),
                testCase.getTested(),
                testCase.getPassed(),
                testCase.getNumber_of_tries(),
                testCase.getLastUpdate()
        );
    }

    @Override
    public TestCaseDTO getEntityById(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElseThrow();

        return new TestCaseDTO(
                testCase.getId_case(),
                testCase.getDescription(),
                testCase.getTested(),
                testCase.getPassed(),
                testCase.getNumber_of_tries(),
                testCase.getLastUpdate()
        );
    }

    @Override
    public List<TestCaseDTO> getAllEntities() {
        List<TestCase> testCases = testCaseRepository.findAll();

        return testCases.stream()
                .map(test -> new TestCaseDTO(
                        test.getId_case(),
                        test.getDescription(),
                        test.getTested(),
                        test.getPassed(),
                        test.getNumber_of_tries(),
                        test.getLastUpdate()
                )).toList();
    }

    @Override
    public MessageDTO deleteEntity(Long id) {
        if (testCaseRepository.existsById(id)) {
            testCaseRepository.deleteById(id);
            return new MessageDTO("Se eliminó el person con id: " + id, "Eliminacion");
        } else {
            return new MessageDTO("No existe o no se pudo eliminar el person con id: " + id, "Eliminacion");
        }
    }

    @Override
    public TestCaseDTO saveUpdate(Long id, TestCaseDTO testCaseDTO) {

        TestCase updateTest = testCaseRepository.findById(testCaseDTO.id_case()).orElseThrow(
                () -> new NotFoundException("No se encontró el test de id "+ testCaseDTO.id_case()));

        updateTest.setDescription(testCaseDTO.description());
        updateTest.setTested(testCaseDTO.tested());
        updateTest.setPassed(testCaseDTO.passed());
        updateTest.setNumber_of_tries(testCaseDTO.number_of_tries());
        updateTest.setLastUpdate(testCaseDTO.last_update());

        testCaseRepository.save(updateTest);

        return testCaseToTestCaseDTO(updateTest);
    }

    @Override
    public List<TestCaseDTO> getTestCasesUpdatedAfterDate(LocalDate last_update) {
        List<TestCase> updatedTestCases = testCaseRepository.findByLastUpdateAfter(last_update);
        return updatedTestCases.stream()
                .map(this::testCaseToTestCaseDTO)
                .collect(Collectors.toList());
    }

    private TestCase testCaseDTOtoTestCase(TestCaseDTO testCaseDTO){
        TestCase testCase = new TestCase();
        testCase.setId_case(testCaseDTO.id_case());
        testCase.setDescription(testCaseDTO.description());
        testCase.setTested(testCaseDTO.tested());
        testCase.setPassed(testCaseDTO.passed());
        testCase.setNumber_of_tries(testCaseDTO.number_of_tries());
        testCase.setLastUpdate(testCaseDTO.last_update());

        return testCase;
    }
    private TestCaseDTO testCaseToTestCaseDTO(TestCase testCase){
        TestCaseDTO testCaseDTO = new TestCaseDTO(
                testCase.getId_case(),
                testCase.getDescription(),
                testCase.getTested(),
                testCase.getPassed(),
                testCase.getNumber_of_tries(),
                testCase.getLastUpdate()
        );
        return testCaseDTO;
    }
}
