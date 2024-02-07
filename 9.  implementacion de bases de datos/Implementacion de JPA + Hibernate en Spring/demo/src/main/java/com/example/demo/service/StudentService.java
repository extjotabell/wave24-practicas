package com.example.demo.service;

import com.example.demo.dto.MessageDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import com.example.demo.repository.IStudentRepository;
import com.example.demo.service.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    private final StudentMapper studentMapper = new StudentMapper();

    @Override
    public StudentDto getById(Long id) {
        var student = studentRepository.findById(id).orElseThrow();

        return studentMapper.StudentToStudentDto(student);
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = studentMapper.StudentDtoToStudent(studentDto);

        student = studentRepository.save(student);

        return studentMapper.StudentToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAll() {
        return studentRepository.findAll().stream().map(
                studentMapper::StudentToStudentDto
        ).toList();
    }

    @Override
    public MessageDto deleteById(Long id) {
        studentRepository.deleteById(id);

        return new MessageDto("Estudiante eliminado");
    }
}
