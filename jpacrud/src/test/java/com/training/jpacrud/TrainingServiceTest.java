package com.training.jpacrud;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


import com.training.jpacrud.Repository.TrainingRepository;
import com.training.jpacrud.model.Training;
import com.training.jpacrud.service.TrainingServiceImpl;


@ExtendWith(MockitoExtension.class)
public class TrainingServiceTest {

	@Autowired
	@InjectMocks
	TrainingServiceImpl trainingService;

	@Mock
	TrainingRepository trainingRepo;

	List<Training> trainingList;
	Page<Training> trainingListPage;
	Training javaTraining;
	Training dotnetTraining;

	@BeforeEach
	public void setup() {
		javaTraining = new Training(1, "A", LocalDate.now(), LocalDate.now(), 100, 8, "A", 31, 31, "Java");
		dotnetTraining = new Training(1, "A", LocalDate.now(), LocalDate.now(), 100, 8, "A", 31, 31, "dotnet");
		trainingList = List.of(javaTraining, dotnetTraining);
	}

  // @Test
	public void verifyListTrainings() {
// mock the data when repo findall method is called
		when(trainingRepo.findAll(PageRequest.of(0, 5))).thenReturn(trainingListPage);

		trainingService.listTrainings(0);
		verify(trainingRepo).findAll(PageRequest.of(0, 5));

	}

	@Test
	public void verifyAddTraining() {
// mock the data when repo findall method is called
		when(trainingRepo.save(javaTraining)).thenReturn(javaTraining);

		trainingService.addtraining(javaTraining);
		verify(trainingRepo).save(javaTraining);

	}
	
	
	
	@Test
	public void verifyUpdateTraining() {
// mock the data when repo findall method is called
		javaTraining = new Training(1, "B", LocalDate.now(), LocalDate.now(), 100, 8, "A", 31, 31, "Java");
		when(trainingRepo.save(javaTraining)).thenReturn(javaTraining);

		trainingService.addtraining(javaTraining);
		verify(trainingRepo).save(javaTraining);

	}
	
	
	@Test
	public void verifyDeleteTraining() {
// mock the data when repo findall method is called
		int id=1;
		trainingService.deleteTrainingById(id);
		verify(trainingRepo).deleteById(id);;

	}
}