package com.practice.testers.controller;

import com.practice.testers.controller.interfaces.ITestCaseController;
import com.practice.testers.dto.MessageDTO;
import com.practice.testers.dto.TestCaseDTO;
import com.practice.testers.service.interfaces.ITestCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api/testcases")
public class TestCaseController implements ITestCaseController {
    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @Override
    @PostMapping("/new")
    public ResponseEntity<MessageDTO> create(@RequestBody TestCaseDTO testCaseDTO) {
        return ResponseEntity.ok(
                testCaseService.save(testCaseDTO)
        );
    }

    @Override
    @GetMapping
    public ResponseEntity<MessageDTO> getAll() {
        return ResponseEntity.ok(
                testCaseService.getAll()
        );
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                testCaseService.getById(id)
        );
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<MessageDTO> updateById(@PathVariable Long id,
                                                 @RequestBody TestCaseDTO testCaseDTO) {
        return ResponseEntity.ok(
                testCaseService.updateById(id, testCaseDTO)
        );
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(
                testCaseService.deleteById(id)
        );
    }
}
