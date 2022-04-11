package com.training.cb_trainingService.service;

import java.net.URISyntaxException;
import java.util.List;

import com.training.cb_trainingService.model.Training;

public interface TrainingService {
	
	public List<Training> findAll() throws URISyntaxException;
	public Training findById(int id);
	public Training save(Training training); 

}

