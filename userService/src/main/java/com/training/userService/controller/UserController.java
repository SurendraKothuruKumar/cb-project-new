package com.training.userService.controller;

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

import com.training.userService.service.UserService;
import com.training.userService.model.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	UserService userService;

	
	
	@GetMapping("/users")
	public ResponseEntity<List> users() {
	   
		return new ResponseEntity<List>(userService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/user")
	public ResponseEntity<User> User(@RequestParam int id) {
	  
		return new ResponseEntity<User>(userService.findById(id), HttpStatus.OK);
	}

	@PostMapping("/createUser")
	public ResponseEntity<User> create(@RequestBody User m) throws Exception {
		
		String tempName = m.getUserName();
		if (tempName != null) {
			User userObj = userService.findUserByUserName(tempName);
			if (userObj != null) {
				throw new Exception("User with Id:" + tempName + " is already exists");
			}
		}
		try {

			return new ResponseEntity<User>(userService.save(m), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping("/user")
	public ResponseEntity<User> update(@RequestBody User m) {
		
		return new ResponseEntity<User>(userService.save(m), HttpStatus.OK);
	}

	@DeleteMapping("/user")
	public ResponseEntity<Boolean> delete(@RequestParam int id) {
		
		return new ResponseEntity<Boolean>(userService.deleteById(id), HttpStatus.OK);
	}

	

	// To Login
	@SuppressWarnings("unused")
		@PostMapping("/login")
		public ResponseEntity<User> loginUser(@RequestBody User user) throws Exception {
			
			String tempUserName=user.getUserName();
			String tempPass= user.getPassword();
			User usertemp = null;
		
			if(tempUserName!= null && tempPass!=null ) {
			
			    usertemp=userService.findByUserNameAndPassword(tempUserName,tempPass);
			}
			if(usertemp == null) { 
				throw new Exception("Bad credential");
			}
			
			return new ResponseEntity<User>(usertemp,HttpStatus.OK);
		}
}
