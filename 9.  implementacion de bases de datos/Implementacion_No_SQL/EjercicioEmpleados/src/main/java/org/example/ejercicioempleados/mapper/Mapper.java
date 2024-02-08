package org.example.ejercicioempleados.mapper;

import org.example.ejercicioempleados.domain.Employee;
import org.example.ejercicioempleados.dto.EmployeeDTO;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public EmployeeDTO convertEmployeeToDto(Employee employee){
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getLastName(),
                employee.getAge(),
                employee.getCity(),
                employee.getState()
        );
    }

    public Employee convertDtoToEmployee(EmployeeDTO employeeDTO){
        return new Employee(
                employeeDTO.id(),
                employeeDTO.name(),
                employeeDTO.lastName(),
                employeeDTO.age(),
                employeeDTO.city(),
                employeeDTO.state()
        );
    }

}
