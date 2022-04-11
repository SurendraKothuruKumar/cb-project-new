package com.training.employeewebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.employeewebservice.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
