package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.StudentWithMessageDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Student;
import com.meli.obtenerdiploma.entity.Subject;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ObtenerDiplomaService implements IObtenerDiplomaService {

    @Autowired
    IStudentRepository studentRepository;

    @Override
    public StudentWithMessageDTO analyzeScores(Long studentId) {
        Student stu = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));

        return new StudentWithMessageDTO(
                stu.getId(),
                stu.getStudentName(),
                stu.getSubjects().stream().map(
                        s -> new SubjectDTO(
                                s.getName(),
                                s.getScore()
                        )
                ).collect(Collectors.toList()),
                getGreetingMessage(stu.getStudentName(), calculateAverage(stu.getSubjects())),
                calculateAverage(stu.getSubjects())
        );
    }

    private String getGreetingMessage(String studentName, Double average) {
        return "El alumno " + studentName + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ((average > 9) ? ". Felicitaciones!" : ". Puedes mejorar.");
    }

    private Double calculateAverage(List<Subject> scores) {
        return scores.stream()
                .reduce(0D, (partialSum, score)  -> partialSum + score.getScore(), Double::sum)
                / scores.size();
    }
}
