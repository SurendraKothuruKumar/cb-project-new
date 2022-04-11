package com.example.LoginProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LoginProject.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, String> {
	User findByUserId(String userId);

	User findByUserIdAndPassword(String tempUserId, String tempPass);

}
