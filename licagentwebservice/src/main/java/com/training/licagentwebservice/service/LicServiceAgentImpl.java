package com.training.licagentwebservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.licagentwebservice.model.LicAgent;
import com.training.licagentwebservice.repository.LicAgentRepository;
@Service
public class LicServiceAgentImpl implements LicAgentService {
	
	@Autowired
	LicAgentRepository laRepo;

	@Override
	public LicAgent findById(int id) {
		// TODO Auto-generated method stub
		return laRepo.findById(id).get();
	}

	@Override
	public List<LicAgent> findAll() {
		// TODO Auto-generated method stub
		return laRepo.findAll();
	}

	@Override
	public LicAgent save(LicAgent agent) {
		// TODO Auto-generated method stub
		return laRepo.save(agent);
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		laRepo.deleteById(id);
		return true;
	}

	@Override
	public List<LicAgent> findAllByManagerId(int managerId) {
		// TODO Auto-generated method stub
		return laRepo.findAllByManagerId(managerId);
	}

}
