package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping("/registerStudent")
    public ResponseEntity<?> registerStudent(@RequestBody @Valid StudentDTO stu) {

        return this.studentService.create(stu) ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(this.studentService.read(id));
    }

    @PostMapping("/modifyStudent")
    public ResponseEntity<?> modifyStudent(@RequestBody @Valid StudentDTO stu) {

        return this.studentService.update(stu) ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }

    @GetMapping("/removeStudent/{id}")
    public ResponseEntity<?> removeStudent(@PathVariable Long id) {

        return this.studentService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }

    @GetMapping("/listStudents")
    public Set<StudentDTO> listStudents() {
        return this.studentService.getAll();
    }

}
