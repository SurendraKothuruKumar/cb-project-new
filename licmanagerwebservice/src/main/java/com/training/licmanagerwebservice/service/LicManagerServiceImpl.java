package com.training.licmanagerwebservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.licmanagerwebservice.model.LicManager;
import com.training.licmanagerwebservice.repository.LicManagerRepository;
@Service
public class LicManagerServiceImpl implements LicmanagerService {
	
	@Autowired
	LicManagerRepository lmRepo;

	@Override
	public LicManager findById(int id) {
		// TODO Auto-generated method stub
		return lmRepo.findById(id).get();
	}

	@Override
	public List<LicManager> findAll() {
		// TODO Auto-generated method stub
		return lmRepo.findAll();
	}

	@Override
	public LicManager save(LicManager manager) {
		// TODO Auto-generated method stub
		return lmRepo.save(manager);
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		lmRepo.deleteById(id);
		return true;
	}

}
