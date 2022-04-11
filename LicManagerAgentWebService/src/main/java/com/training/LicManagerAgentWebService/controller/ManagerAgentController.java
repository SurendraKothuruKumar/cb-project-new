package com.training.LicManagerAgentWebService.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.LicManagerAgentWebService.service.ManagerAgentService;

@RestController
public class ManagerAgentController {

	@Autowired
	ManagerAgentService maService;
	@GetMapping("/managers")
	public ResponseEntity<List> findAllManagersWithAgents() throws URISyntaxException{
		return new ResponseEntity<List>(maService.findAll(),HttpStatus.OK);
	}
	
	
}
