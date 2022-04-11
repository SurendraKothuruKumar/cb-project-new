package com.training.jpacrud.Repository;
 



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.jpacrud.model.Training;
 

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {
 
	Page<Training> findAll(Pageable pageable);
}