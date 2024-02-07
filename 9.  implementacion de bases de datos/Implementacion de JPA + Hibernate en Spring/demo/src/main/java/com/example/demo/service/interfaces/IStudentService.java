package com.example.demo.service.interfaces;

import com.example.demo.dto.StudentDto;
import com.example.demo.service.interfaces.generics.ICrudService;

public interface IStudentService extends ICrudService<StudentDto, Long> {
}
