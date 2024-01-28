package com.meli.obtenerdiploma.unit.integration;

//integration

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {


    @Autowired
    MockMvc mvc;  //objeto de la clase abstracta : requests


    //metodos
//    @GetMapping("/getStudent/{id}")
//    public ResponseEntity<?> getStudent(@PathVariable Long id) {
//        return ResponseEntity.ok(this.studentService.read(id));
//    }

    //bien
    @Test
    public void testStudentbyId(){

        //Arrange : informacion que recibe el parametro, retorno

        Long id = 1L;
        ResponseEntity entity;



        //Act / Asserts

    }

    @Test
    public void testListStudents() throws Exception {

        //Arrange
        Set<StudentDTO> studentsListDTO = new HashSet<>();
        StudentDTO student = new StudentDTO( 1L, "Juan", Set.of(new SubjectDTO("Math", 100.0), new SubjectDTO("English", 50.0), new SubjectDTO("Science", 80.0)));
        StudentDTO student2 = new StudentDTO( 2L, "Jose", Set.of(new SubjectDTO("Math", 100.0), new SubjectDTO("English", 50.0), new SubjectDTO("Science", 80.0)));

        studentsListDTO.add(student);
        studentsListDTO.add(student2);
        System.out.println(studentsListDTO);
        ObjectWriter w = new ObjectMapper().writer();

        //request

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/listStudents");

        //expected
        ResultMatcher expected = MockMvcResultMatchers.status().isOk();  //200
        ResultMatcher expected2 = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON) ;
        ResultMatcher expected3 = MockMvcResultMatchers.content().json(w.writeValueAsString(studentsListDTO));//200

        mvc.perform(request) //que va a ejecutar
                .andExpect(expected) //status
                .andExpect(expected2) // content type
                .andExpect(expected3)//
                .andDo(MockMvcResultHandlers.print());

    }




    //mel
}
