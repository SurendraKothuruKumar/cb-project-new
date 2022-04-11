package com.training.LicManagerAgentWebService.service;

import java.net.URISyntaxException;
import java.util.List;

import com.training.LicManagerAgentWebService.model.LicManager;

public interface ManagerAgentService {
	public List<LicManager> findAll() throws URISyntaxException;

}
