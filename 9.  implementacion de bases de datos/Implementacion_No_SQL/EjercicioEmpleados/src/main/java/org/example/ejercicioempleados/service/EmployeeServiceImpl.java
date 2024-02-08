package org.example.ejercicioempleados.service;

import org.example.ejercicioempleados.domain.Employee;
import org.example.ejercicioempleados.dto.EmployeeDTO;
import org.example.ejercicioempleados.mapper.Mapper;
import org.example.ejercicioempleados.repository.IEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
    private final IEmployeeRepository employeeRepository;

    private final Mapper mapper;

    public EmployeeServiceImpl(IEmployeeRepository employeeRepository, Mapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = mapper.convertDtoToEmployee(employeeDTO);
        employee = employeeRepository.save(employee);
        return mapper.convertEmployeeToDto(employee);
    }

    @Override
    public EmployeeDTO getEmployeeById(String id) {
        return null;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return null;
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, String id) {
        return null;
    }
}
