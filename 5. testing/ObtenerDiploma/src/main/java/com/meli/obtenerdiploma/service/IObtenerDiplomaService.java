package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.StudentWithMessageDTO;

public interface IObtenerDiplomaService {

    StudentWithMessageDTO analyzeScores(Long studentId);
}
