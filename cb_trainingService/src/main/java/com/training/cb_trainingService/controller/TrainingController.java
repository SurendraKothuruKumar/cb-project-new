package com.training.cb_trainingService.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.training.cb_trainingService.model.Training;
import com.training.cb_trainingService.service.TrainingService;

@RestController
public class TrainingController {
	
	@Autowired
	TrainingService trainingService;
	
	@GetMapping("/trainings")
	public ResponseEntity<List> findAll() throws URISyntaxException {
		return new ResponseEntity<List>(trainingService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/training")
	public ResponseEntity<Training> findById(@RequestParam int id) {
		return new ResponseEntity<Training>(trainingService.findById(id),HttpStatus.OK);
	}
	
	@PostMapping("/training")
	public ResponseEntity<Training> create(@RequestBody Training training) {
		return new ResponseEntity<Training>(trainingService.save(training),HttpStatus.CREATED);
	}
}

