package com.training.userService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.userService.model.User;
@Repository
public interface userRepository extends JpaRepository<User, Integer> {
	public List<User> findAllByUserId(int id);
	public User findByUserNameAndPassword(String tempUserName, String tempPass);
	public User findUserByUserName(String tempName);

}
