package com.training.userService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.training.userService.model.User;
import com.training.userService.repository.userRepository;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	userRepository userRepo;

	
	
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		
		return userRepo.findAll(); 
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		
		return userRepo.findById(id).orElse(null);
	}

	@Override
	public User save(User m) {
		// TODO Auto-generated method stub
		
		return userRepo.save(m);
	}

	@Override
	public Boolean deleteById(int id) {
		// TODO Auto-generated method stub
		
		userRepo.deleteById(id);
		return true;
	}

	

	
	
	

	@Override
	public User findByUserNameAndPassword(String tempUserName, String tempPass) {
		// TODO Auto-generated method stub
		
		return userRepo.findByUserNameAndPassword( tempUserName,tempPass);
	}

	@Override
	public User findUserByUserName(String tempName) {
		// TODO Auto-generated method stub
		
		return userRepo.findUserByUserName( tempName);
	}

}
