package org.covid19.ejerciciocovid19.services;

import org.covid19.ejerciciocovid19.models.Personas;

public class PersonaService {
    Personas persona;
    Personas persona2;
    Personas persona3;
    public PersonaService() {
        persona = new Personas(1, "Javier", "Cordero", 25);
        persona2 = new Personas(2, "Lina", "Amaya", 55);
        persona3 = new Personas(3, "Carlos", "Toro", 85);
    }

}
