package com.example.qatesters.controller;

import com.example.qatesters.dto.MessageDTO;
import com.example.qatesters.dto.TestCaseDTO;
import com.example.qatesters.dto.UpdatedTestRespondeDTO;
import com.example.qatesters.service.interfaces.ITestCaseService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("api/testcases")
public class TestCaseController {

    @Autowired
    private ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<String> create(@RequestBody TestCaseDTO testCasedto){
        TestCaseDTO newTestsCase = testCaseService.saveEntity(testCasedto);

        String message = "Se ha creado un nuevo caso de prueba";
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @GetMapping("")
    public ResponseEntity<List<TestCaseDTO>> getAll(@RequestParam(value = "last_update", required = false)
                                                        @DateTimeFormat(pattern = "dd/MM/yyyy")
                                                        LocalDate lastUpdate){
        List<TestCaseDTO> testCases;

        if (lastUpdate != null) {
            testCases = testCaseService.getTestCasesUpdatedAfterDate(lastUpdate);
        } else {
            testCases = testCaseService.getAllEntities();
        }

        return ResponseEntity.ok(testCases);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getTestById(@PathVariable Long id){
        return ResponseEntity.ok(testCaseService.getEntityById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdatedTestRespondeDTO> updateTestById(@PathVariable Long id,
                                                                 @RequestBody TestCaseDTO testCaseDTO){
        TestCaseDTO updatedTest = testCaseService.saveUpdate(id, testCaseDTO);

        String message = "Se ha actualizado el test de id " + id;

        UpdatedTestRespondeDTO response = new UpdatedTestRespondeDTO(message,updatedTest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteTestById(@PathVariable Long id){
        return ResponseEntity.ok(testCaseService.deleteEntity(id));
    }

}
