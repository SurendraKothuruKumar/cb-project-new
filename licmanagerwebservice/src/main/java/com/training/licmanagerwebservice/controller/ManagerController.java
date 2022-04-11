package com.training.licmanagerwebservice.controller;

import java.util.List;

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

import com.training.licmanagerwebservice.model.LicManager;
import com.training.licmanagerwebservice.service.LicmanagerService;

@RestController
public class ManagerController {
	
	@Autowired
	LicmanagerService lmService;
	
	@GetMapping("/managers")
	public ResponseEntity<List> managers(){
		return new ResponseEntity<List>(lmService.findAll(),HttpStatus.OK);
	}
	@GetMapping("/manager")
	public ResponseEntity<LicManager> manager(@RequestParam int id){
		return new ResponseEntity<LicManager>(lmService.findById(id),HttpStatus.OK);
	}
	@PostMapping("/manager")
	public ResponseEntity<LicManager> createManager(@RequestBody LicManager lm){
		return new ResponseEntity<LicManager>(lmService.save(lm),HttpStatus.OK);
	}
	@PutMapping("/manager")
	public ResponseEntity<LicManager> updateManager(@RequestBody LicManager lm){
		return new ResponseEntity<LicManager>(lmService.save(lm),HttpStatus.OK);
	}
	@DeleteMapping("/manager")
	public ResponseEntity<String> deletemanager(@RequestParam int id){
		lmService.deleteById(id);
		return new ResponseEntity<String>("Succefulluy Deleted",HttpStatus.OK);
	}
	

}
