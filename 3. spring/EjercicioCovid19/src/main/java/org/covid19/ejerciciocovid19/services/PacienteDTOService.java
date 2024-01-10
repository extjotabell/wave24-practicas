package org.covid19.ejerciciocovid19.services;

import org.covid19.ejerciciocovid19.dto.PacienteDTO;

import java.util.List;

public class PacienteDTOService {
    PacienteDTO paciente;
    PacienteDTO paciente2;
    PacienteDTO paciente3;
    SintomasService sintomasService = new SintomasService();
    PersonaService personaService = new PersonaService();
    List<PacienteDTO> pacienteDTOList;

    public PacienteDTOService() {
        paciente = new PacienteDTO(personaService.persona.getNombres(), personaService.persona.getApellidos(), personaService.persona.getEdad(), null);
        paciente2 = new PacienteDTO(personaService.persona2.getNombres(), personaService.persona2.getApellidos(), personaService.persona2.getEdad(), sintomasService.obtenerSintomas());
        paciente3 = new PacienteDTO(personaService.persona3.getNombres(), personaService.persona3.getApellidos(), personaService.persona3.getEdad(), sintomasService.obtenerSintomas());
        pacienteDTOList = List.of(paciente, paciente2, paciente3);
    }
    public List<PacienteDTO> obtenerPacientes() {
        var pacienteEnRiesgo = pacienteDTOList.stream().filter(pacienteDTO -> pacienteDTO.edad() > 60 && !pacienteDTO.sintomas().isEmpty());
        return pacienteEnRiesgo.toList();
    }
}
