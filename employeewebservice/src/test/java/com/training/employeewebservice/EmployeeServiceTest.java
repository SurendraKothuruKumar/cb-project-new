package com.training.employeewebservice;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.training.employeewebservice.model.Employee;
import com.training.employeewebservice.repository.EmployeeRepository;
import com.training.employeewebservice.service.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@Autowired
	@InjectMocks
	EmployeeServiceImpl employeeService;

	@Mock
	EmployeeRepository employeeRepo;

	@BeforeEach
	public void setup() {
	}

	@Test
	public void verifyGetEmployees() {
		Employee e1 = new Employee(1,"Sun",243.0f,23); // lombok project dependency
		List<Employee> empList = List.of(e1); // new java version
		when(employeeRepo.findAll()).thenReturn(empList);
		employeeService.findAll();

		verify(employeeRepo).findAll();
	}
	@Test
	public void verifyGetEmployee() {
	Optional<Employee> e1 = Optional.of(new Employee(1,"Sun",243.0f,23)); // lombok
	// project
	// dependency
	when(employeeRepo.findById((long) 1)).thenReturn(e1);
	employeeService.findById(1);



	verify(employeeRepo).findById((long) 1);
	}

}
