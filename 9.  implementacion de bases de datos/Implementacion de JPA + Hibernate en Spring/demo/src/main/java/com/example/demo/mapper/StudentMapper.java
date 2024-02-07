package com.example.demo.mapper;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;

public class StudentMapper {
    public StudentDto StudentToStudentDto(Student student) {
        return new StudentDto(
                student.getId(),
                student.getDni(),
                student.getName(),
                student.getLastName()
        );
    }

    public Student StudentDtoToStudent(StudentDto studentDto) {
        return new Student(
                studentDto.id(),
                studentDto.dni(),
                studentDto.name(),
                studentDto.lastName()
        );
    }
}
