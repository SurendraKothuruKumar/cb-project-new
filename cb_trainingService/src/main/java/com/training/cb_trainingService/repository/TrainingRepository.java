package com.training.cb_trainingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.cb_trainingService.model.Training;
@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {

}
