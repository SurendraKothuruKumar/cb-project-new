package com.training.licmanagerwebservice.service;

import java.util.List;

import com.training.licmanagerwebservice.model.LicManager;

public interface LicmanagerService {
	public LicManager findById(int id);
	public List<LicManager> findAll();
	public LicManager save(LicManager manager);
	public boolean deleteById(int id);

}
