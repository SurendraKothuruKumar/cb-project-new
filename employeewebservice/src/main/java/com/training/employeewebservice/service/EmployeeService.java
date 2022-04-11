package com.training.employeewebservice.service;

import java.util.List;

import com.training.employeewebservice.model.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(long id);
	public boolean deleteById(long id);
	public Employee save(Employee emp);

}
