package com.training.licagentwebservice.service;

import java.util.List;

import com.training.licagentwebservice.model.LicAgent;


public interface LicAgentService {
	
	public LicAgent findById(int id);
	public List<LicAgent> findAll();
	public List<LicAgent> findAllByManagerId(int managerId);
	public LicAgent save(LicAgent agent);
	public boolean deleteById(int id);

}
