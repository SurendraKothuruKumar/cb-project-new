package com.training.policyService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.policyService.model.Policy;
import com.training.policyService.repository.PolicyRepository;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	PolicyRepository policyRepo;
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return policyRepo.findAll();
	}

	@Override
	public Policy findById(int id) {
		// TODO Auto-generated method stub
		return policyRepo.findById(id).orElse(null);
	}

	@Override
	public Policy save(Policy m) {
		// TODO Auto-generated method stub
		return policyRepo.save(m);
	}

	@Override
	public Boolean deleteById(int id) {
		// TODO Auto-generated method stub
		policyRepo.deleteById(id);
		return true;
	}

	@Override
	public List<Policy> findAllByPolicyType(String policyType) {
		// TODO Auto-generated method stub
		return policyRepo.findAllByPolicyType(policyType);
	}

	

	

	

	


}
