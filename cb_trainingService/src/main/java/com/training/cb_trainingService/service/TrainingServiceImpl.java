package com.training.cb_trainingService.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.cb_trainingService.model.Topic;
import com.training.cb_trainingService.model.Training;
import com.training.cb_trainingService.repository.TrainingRepository;


@Service
public class TrainingServiceImpl implements TrainingService {

	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	TrainingRepository trainingRepo;

	@Override
	public List<Training> findAll() throws URISyntaxException {
		List<Training> trainingList = trainingRepo.findAll();
		for (Training training : trainingList) {
			Topic[] result = getTopicList(training);

			training.setTopics(Arrays.asList(result));
		}
		return trainingList;
	}

	private Topic[] getTopicList(Training training) throws URISyntaxException {

		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");

		final String topicUrl = "http://TOPICSERVICE/topicsByTrainingId?trainingId=" + training.getId();
		URI topicURI = new URI(topicUrl);

		return circuitBreaker.run(() -> restTemplate.getForEntity(topicURI, Topic[].class).getBody(), throwable -> getDefaultTopic());

	}

	private Topic[] getDefaultTopic() {
		Topic[] topicList = {new Topic(0,0,"Training Topics Not created.")};
		return topicList;
	}

	@Override
	public Training findById(int id) {
		return trainingRepo.findById(id).get();
	}

	@Override
	public Training save(Training training) {
		return trainingRepo.save(training);
	}

}
