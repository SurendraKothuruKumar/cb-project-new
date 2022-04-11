package com.training.jpacrud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.training.jpacrud.Repository.TrainingRepository;
import com.training.jpacrud.model.Training;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTest {

	@Autowired
	TrainingRepository trainingRepository;

	@Test
	void trainingCreate() {
		Training training = new Training(1, "A", LocalDate.now(), LocalDate.now(), 100, 8, "A", 31, 31, "Java");
		Training training2 = trainingRepository.save(training);
		assertEquals(training, training2);
	}
    
	
	
    
	
	
	
	
}