package com.training.policyService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.policyService.model.Policy;
@Service
public interface PolicyService {
	
	public  List findAll();

	public  Policy findById(int id);

	public  Policy save(Policy m);

	public  Boolean deleteById(int id);

	public List<Policy> findAllByPolicyType(String policyType);


}
