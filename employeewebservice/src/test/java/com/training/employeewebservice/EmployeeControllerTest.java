package com.training.employeewebservice;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import com.training.employeewebservice.model.Employee;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

	@LocalServerPort
	int randomServerPort;

	@Test
	public void testGetEmployees() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl2 = "http://localhost:" + randomServerPort + "/employee";
		URI uri2 = new URI(baseUrl2);

		ResponseEntity<Employee> result2 = restTemplate.postForEntity(uri2, new Employee(1,"Sun",243.0f,23), Employee.class);
		Employee testEmp = result2.getBody();

// Verify request succeed
		Assertions.assertEquals(200, result2.getStatusCodeValue());

		final String baseUrl = "http://localhost:" + randomServerPort + "/employees";
		URI uri = new URI(baseUrl);

		ResponseEntity<Employee[]> result = restTemplate.getForEntity(uri, Employee[].class);

		System.out.println(result.getBody());

// Verify request succeed
		Assertions.assertEquals(200, result.getStatusCodeValue());

		Assertions.assertEquals(true, List.of(result.getBody()).contains(testEmp)); // Object verification

		Assertions.assertEquals(true, result.getBody()[0].getName().equals("Sun")); // Name verification
// using array's
// first element

		Assertions.assertEquals(true,
				List.of(result.getBody()).stream().anyMatch((var) -> var.getName().equals("Sun"))); // Name
// verification
// using java stream name verification in any record

	}
	@Test
	public void testGetEmployee() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl2 = "http://localhost:" + randomServerPort + "/employee";
		URI uri2 = new URI(baseUrl2);

		ResponseEntity<Employee> result2 = restTemplate.postForEntity(uri2, new Employee(1,"Sun",243.0f,23), Employee.class);
		Employee testEmp = result2.getBody();

// Verify request succeed
		Assertions.assertEquals(200, result2.getStatusCodeValue());

		final String baseUrl = "http://localhost:" + randomServerPort + "/employee?id="+testEmp.getId();
		URI uri = new URI(baseUrl);

		ResponseEntity<Employee> result = restTemplate.getForEntity(uri, Employee.class);

		System.out.println(result.getBody());

// Verify request succeed
		Assertions.assertEquals(200, result.getStatusCodeValue());

		Assertions.assertEquals(true, List.of(result.getBody()).contains(testEmp)); // Object verification

		
	}

}
