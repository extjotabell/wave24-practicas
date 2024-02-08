package org.example.ejercicioempleados.repository;

import org.example.ejercicioempleados.domain.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {
}
