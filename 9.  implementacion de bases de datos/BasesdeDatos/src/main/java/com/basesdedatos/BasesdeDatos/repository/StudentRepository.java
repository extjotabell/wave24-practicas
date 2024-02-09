package com.basesdedatos.BasesdeDatos.repository;

import com.basesdedatos.BasesdeDatos.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{ //clase a mapear  y el tipo de dato del id


}
