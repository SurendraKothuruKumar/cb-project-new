package com.training.jpacrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import com.training.jpacrud.Repository.TrainingRepository;
import com.training.jpacrud.model.Training;


@Service
public class TrainingServiceImpl implements TrainingService{

	
	
	@Autowired
	TrainingRepository trainRepository;

	
	@Override
	public List<Training> listTrainings(int pageNumber) {

	return trainRepository.findAll(PageRequest.of(pageNumber, 5)).toList();
	}

	@Override
	public Training addtraining(Training training) {
		// TODO Auto-generated method stub
		return trainRepository.save(training);
	}


	@Override
	public Training getTrainingById(int id) {
		// TODO Auto-generated method stub
		return this.trainRepository.getById(id);
	}


	@Override
	public boolean deleteTrainingById(int id) {
		// TODO Auto-generated method stub
		this.trainRepository.deleteById(id);
		return true;
	}

}
