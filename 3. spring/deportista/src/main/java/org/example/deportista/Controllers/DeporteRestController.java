package org.example.deportista.Controllers;


import org.example.deportista.Entities.Deporte;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class DeporteRestController {

    List<Deporte> deportes = new ArrayList<>(Arrays.asList(
            new Deporte("Futbol", 1),
            new Deporte("Tenis", 2),
            new Deporte("Natación", 3)
    ));



}
