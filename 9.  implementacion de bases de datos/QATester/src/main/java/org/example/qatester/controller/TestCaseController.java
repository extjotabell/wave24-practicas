package org.example.qatester.controller;

import org.example.qatester.dto.ResponseDto;
import org.example.qatester.dto.TestCaseDto;
import org.example.qatester.service.TestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TestCaseController {

    private final TestCaseService testCaseService;

    public TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/api/testcases/new")
    public ResponseEntity<TestCaseDto> saveTestCase(@RequestBody TestCaseDto testCaseDto){
        return new ResponseEntity<>(testCaseService.saveTestCase(testCaseDto), HttpStatus.OK);
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<List<TestCaseDto>> getAllTestCase(){
        return new ResponseEntity<>(testCaseService.getAllTestCase(), HttpStatus.OK);
    }

    @GetMapping("/api/testcases/{id}")
    public ResponseEntity<TestCaseDto> getTestCaseById(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/api/testcases/{id}")
    public ResponseEntity<TestCaseDto> updateTestCaseById(@PathVariable Long id, @RequestBody TestCaseDto testCaseDto){
        return new ResponseEntity<>(testCaseService.updateTestCase(id, testCaseDto), HttpStatus.OK);
    }

    @DeleteMapping("/api/testcases/{id}")
    public ResponseEntity<ResponseDto> deleteTestCaseById(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.deleteTestCaseById(id), HttpStatus.OK);
    }

    @GetMapping("/api/testcases/")
    public ResponseEntity<List<TestCaseDto>> findTestCaseUpdatedAfterDate(@RequestParam("last_update") LocalDate date){
        return new ResponseEntity<>(testCaseService.findTestCaseUpdatedAfterDate(date), HttpStatus.OK);
    }
}
