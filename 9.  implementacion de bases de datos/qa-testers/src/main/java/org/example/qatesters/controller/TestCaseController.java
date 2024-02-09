package org.example.qatesters.controller;

import org.example.qatesters.model.TestCase;
import org.example.qatesters.service.ITestCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<TestCase> createTestCase(@RequestBody TestCase testCase) {
        return ResponseEntity.ok(testCaseService.addTestCase(testCase));
    }

    @GetMapping
    public ResponseEntity<List<TestCase>> getAllTestCases(@RequestParam(value = "last_update", required = false) String date) {
        if (date != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate searchDate = LocalDate.parse(date, formatter);
            return ResponseEntity.ok(testCaseService.searchTestCasesByDate(searchDate));
        }

        return ResponseEntity.ok(testCaseService.findAllTestCases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> getTestCase(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.findOneTestCase(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCase> updateTestCase(@PathVariable Long id, @RequestBody TestCase testCase) {
        return ResponseEntity.ok(testCaseService.updateTestCase(id, testCase));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        return testCaseService.deleteTestCase(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
