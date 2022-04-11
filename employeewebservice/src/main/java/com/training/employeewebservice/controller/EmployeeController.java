package com.training.employeewebservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.employeewebservice.model.Employee;
import com.training.employeewebservice.service.EmployeeService;

@RestController
public class EmployeeController {
	public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/employees")
	public ResponseEntity<List> employees(){
		LOGGER.debug("Retrive all employees...");
		return new ResponseEntity(empService.findAll(),HttpStatus.OK);
	}
	@GetMapping("/employee")
	public ResponseEntity employee( long id){
		return new ResponseEntity(empService.findById(id),HttpStatus.OK);
	}
	@PostMapping("/employee")
	public ResponseEntity create(@RequestBody Employee emp){
		return new ResponseEntity(empService.save(emp),HttpStatus.OK);
	}
	@PutMapping("/employee")
	public ResponseEntity update(@RequestBody Employee emp){
		return new ResponseEntity(empService.save(emp),HttpStatus.OK);
	}
	@DeleteMapping("/employee")
	public ResponseEntity delete( long id){
		return new ResponseEntity(empService.deleteById(id),HttpStatus.OK);
	}

}
