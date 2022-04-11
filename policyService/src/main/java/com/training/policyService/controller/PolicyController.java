package com.training.policyService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.policyService.service.PolicyService;
import com.training.policyService.model.Policy;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PolicyController {

	@Autowired
	PolicyService policyService;
	
	
	

	@GetMapping("/Policys")
	public ResponseEntity<List> Policys() {
		
		return new ResponseEntity<List>(policyService.findAll(),HttpStatus.OK);
	}		

	@GetMapping("/Policy")
	public ResponseEntity<Policy> Policy(@RequestParam int id) {
		
		return new ResponseEntity<Policy>(policyService.findById(id),HttpStatus.OK);
	}	

	@PostMapping("/createPolicy")
	public ResponseEntity<Policy> create(@RequestBody Policy m) {
		
		return new ResponseEntity<Policy>(policyService.save(m),HttpStatus.OK);
	}

	@PutMapping("/Policy")
	public ResponseEntity<Policy> update(@RequestBody Policy m) {
		
		return new ResponseEntity<Policy>(policyService.save(m),HttpStatus.OK);
	}

	@DeleteMapping("/Policy")
	public ResponseEntity<Boolean> delete(@RequestParam int id) {
		
		return new ResponseEntity<Boolean>(policyService.deleteById(id),HttpStatus.OK);
	}
	@GetMapping("/searchPolicy")
	public ResponseEntity<List> searchpolicy(@RequestParam String policyType){
		
		return new ResponseEntity<List>(policyService.findAllByPolicyType(policyType),HttpStatus.OK);
		
	}


}
