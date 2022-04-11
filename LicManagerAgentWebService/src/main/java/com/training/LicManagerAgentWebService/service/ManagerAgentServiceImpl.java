package com.training.LicManagerAgentWebService.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.LicManagerAgentWebService.model.LicAgent;
import com.training.LicManagerAgentWebService.model.LicManager;

@Service
public class ManagerAgentServiceImpl implements ManagerAgentService {

	@Override
	public List<LicManager> findAll() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String mgrUrl = "http://localhost:4321/managers";
		URI mgrURI = new URI(mgrUrl);

		ResponseEntity<LicManager[]> mgrResult = restTemplate.getForEntity(mgrURI, LicManager[].class);

		LicManager[] mgrList = mgrResult.getBody();

		for (LicManager mgr : Arrays.asList(mgrList)) {
			final String agentUrl = "http://localhost:1234/agentsByManager?mgrId=" + mgr.getId();
			URI agentURI = new URI(agentUrl);

			ResponseEntity<LicAgent[]> agentResult = restTemplate.getForEntity(agentURI, LicAgent[].class);

			LicAgent[] agentList = agentResult.getBody();

			mgr.setAgentList(Arrays.asList(agentList));

		}
		return Arrays.asList(mgrList);
	}

}
