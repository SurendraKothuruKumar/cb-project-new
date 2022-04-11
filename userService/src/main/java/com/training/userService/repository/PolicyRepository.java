package com.training.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.userService.model.Policy;
@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer> {
	

}
