package com.training.jpacrud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.jpacrud.model.Training;


@Service
public interface TrainingService {

	
	public List<Training> listTrainings(int pageNumber);

	public Training addtraining(Training training);

	public Training getTrainingById(int id);

	public boolean deleteTrainingById(int id);
	
}
