package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class FindControllerTest {

    @Mock
    private FindService findService;


    @InjectMocks
    private FindController findController;


    @Test
    public void find() {
        List<CharacterDTO> expectedFindResult = new ArrayList<CharacterDTO>();

        when(this.findService.find(anyString())).thenReturn(new ArrayList<CharacterDTO>());

        List<CharacterDTO> actualFindResult = this.findController.find("Anakin");

        // Assert result

        Assertions.assertEquals(expectedFindResult, actualFindResult);



    }
}
