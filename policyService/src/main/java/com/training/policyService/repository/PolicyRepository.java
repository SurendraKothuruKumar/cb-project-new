package com.training.policyService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.policyService.model.Policy;
@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer> {
	public List<Policy> findAllByPolicyType(String policyType);

}
