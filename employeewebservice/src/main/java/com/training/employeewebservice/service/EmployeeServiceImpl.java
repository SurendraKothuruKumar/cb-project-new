package com.training.employeewebservice.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.employeewebservice.controller.EmployeeController;
import com.training.employeewebservice.model.Employee;
import com.training.employeewebservice.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository empRepository;

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		EmployeeController.LOGGER.debug("Retrive all employees from service method...");
		return empRepository.findAll();
	}

	@Override
	public Employee findById(long id) {
		// TODO Auto-generated method stub
		EmployeeController.LOGGER.debug("Retrive all employees by id"+id+" from service method...");
		return empRepository.findById(id).get();
	}

	@Override
	public boolean deleteById(long id) {
		// TODO Auto-generated method stub
		EmployeeController.LOGGER.debug("Delete the employees by id"+id+" from service method...");
		 empRepository.deleteById(id);
		 return true;
	}

	@Override
	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		EmployeeController.LOGGER.debug("saving the employee"+emp+" from service method...");
		return empRepository.save(emp);
	}
	
}
