package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    private ObtenerDiplomaService service;

    @InjectMocks
    private ObtenerDiplomaController controller;

    @BeforeEach
    void setUp() {
    }

    @Test
    void analyzeScores() {
        Mockito.when(service.analyzeScores(1L)).thenReturn(null
        );
        assertNull(controller.analyzeScores(1L).getBody());
    }
}