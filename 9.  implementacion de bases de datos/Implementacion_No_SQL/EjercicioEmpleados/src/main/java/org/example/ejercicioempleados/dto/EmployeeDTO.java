package org.example.ejercicioempleados.dto;

public record EmployeeDTO(
        String id,
        String name,
        String lastName,
        Integer age,
        String city,
        String state
) {
}
