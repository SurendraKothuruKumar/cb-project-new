package com.example.LoginProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.LoginProject.model.User;
import com.example.LoginProject.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@PostMapping("/user")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		return ResponseEntity.ok(repo.save(user));
	}
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody User user) throws Exception{
		String tempUserId=user.getUserId();
		String tempPass= user.getPassword();
		User usertemp = null;
	
		if(tempUserId!= null && tempPass!=null ) {
		
		    usertemp=repo.findByUserIdAndPassword(tempUserId,tempPass);
		}
		if(usertemp == null) { 
			throw new Exception("Bad credential");
		}
		
		return new ResponseEntity<User>(usertemp,HttpStatus.OK);
	}
	

}
