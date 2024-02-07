package com.example.demo.controller;

import com.example.demo.dto.MessageDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.service.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @PostMapping("/")
    public ResponseEntity<StudentDto> create(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(
                studentService.save(studentDto)
        );
    }

    @GetMapping("/")
    public ResponseEntity<List<StudentDto>> getAll() {
        return ResponseEntity.ok(
                studentService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                studentService.getById(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable Long id) {
        return ResponseEntity.ok(
                studentService.deleteById(id)
        );
    }
}
