package org.meli.co.covid19.service;

import org.meli.co.covid19.model.PacienteDTO;

import java.util.List;

public class PacienteDTOService {

    private List<PacienteDTO> pacientes;

    private SintomaService sintomaService;

    public PacienteDTOService() {

        SintomaService sintomaService = new SintomaService();

        PacienteDTO pacienteDTO = new PacienteDTO("Juan", "Perez", 30, List.of(sintomaService.getSintomaByName("Tos")));

        PacienteDTO pacienteDTO2 = new PacienteDTO("Maria", "Gomez", 40, List.of(sintomaService.getSintomaByName("Fiebre")));

        PacienteDTO pacienteDTO3 = new PacienteDTO("Pedro", "Gonzalez", 50, List.of(sintomaService.getSintomaByName("Dolor de cabeza")));




        this.pacientes = List.of(pacienteDTO, pacienteDTO2, pacienteDTO3);

    }

    public List<PacienteDTO> getPacientes() {
        var pacienteEnRiesgo = pacientes.stream().filter(pacienteDTO -> pacienteDTO.getEdad() > 60 && !pacienteDTO.getSintomas().isEmpty());
        return pacienteEnRiesgo.toList();
    }


}
