package org.example.ejercicioempleados.service;

import org.example.ejercicioempleados.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(String id);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, String id);


}
