package org.tester.qatester.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.tester.qatester.dto.MessageDTO;
import org.tester.qatester.dto.TestCaseDTO;
import org.tester.qatester.service.interfaces.ITestCaseService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testCases")
public class TestCaseController {

    ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<TestCaseDTO> save(@RequestBody TestCaseDTO testCaseDTO) {
        return ResponseEntity.ok(testCaseService.save(testCaseDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDTO> update(@RequestBody TestCaseDTO testCaseDTO, @PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.update(testCaseDTO, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<TestCaseDTO>> findAll() {
        return ResponseEntity.ok(testCaseService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> delete(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.delete(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<TestCaseDTO>> findByLastUpdateAfter(@RequestParam("last_update") @JsonFormat(pattern = "dd/MM/yyyy") LocalDate date) {
        return ResponseEntity.ok(testCaseService.findByLastUpdateAfter(date));
    }

}
