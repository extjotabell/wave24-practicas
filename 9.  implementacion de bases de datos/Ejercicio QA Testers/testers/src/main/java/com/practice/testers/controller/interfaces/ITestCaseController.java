package com.practice.testers.controller.interfaces;

import com.practice.testers.controller.interfaces.generics.ICrudController;
import com.practice.testers.dto.MessageDTO;
import com.practice.testers.dto.TestCaseDTO;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface ITestCaseController extends ICrudController<MessageDTO, TestCaseDTO> {
}
