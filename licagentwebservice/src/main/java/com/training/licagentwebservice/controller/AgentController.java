package com.training.licagentwebservice.controller;

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

import com.training.licagentwebservice.model.LicAgent;
import com.training.licagentwebservice.service.LicAgentService;


@RestController
public class AgentController {
	
	@Autowired
	LicAgentService laService;
	
	@GetMapping("/agents")
	public ResponseEntity<List> managers(){
		return new ResponseEntity<List>(laService.findAll(),HttpStatus.OK);
	}
	@GetMapping("/agent")
	public ResponseEntity<LicAgent> manager(@RequestParam int id){
		return new ResponseEntity<LicAgent>(laService.findById(id),HttpStatus.OK);
	}
	@PostMapping("/agent")
	public ResponseEntity<LicAgent> createManager(@RequestBody LicAgent lm){
		return new ResponseEntity<LicAgent>(laService.save(lm),HttpStatus.OK);
	}
	@PutMapping("/agent")
	public ResponseEntity<LicAgent> updateManager(@RequestBody LicAgent lm){
		return new ResponseEntity<LicAgent>(laService.save(lm),HttpStatus.OK);
	}
	@DeleteMapping("/agent")
	public ResponseEntity<String> deletemanager(@RequestParam int id){
		laService.deleteById(id);
		return new ResponseEntity<String>("Succefulluy Deleted",HttpStatus.OK);
	}
	@GetMapping("/agentsByManager")
	public ResponseEntity<List> Agent(@RequestParam int mgrId){
		return new ResponseEntity<List>(laService.findAllByManagerId(mgrId),HttpStatus.OK);
	}
	

}
