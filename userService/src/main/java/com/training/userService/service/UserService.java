package com.training.userService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.userService.model.User;
@Service
public interface UserService {
	public  List findAll();

	public  User findById(int id);

	public  User save(com.training.userService.model.User m);

	public  Boolean deleteById(int id);

	public User findByUserNameAndPassword(String tempUserName, String tempPass);

	public User findUserByUserName(String tempName);

}
