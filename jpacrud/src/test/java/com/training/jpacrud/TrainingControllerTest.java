package com.training.jpacrud;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.training.jpacrud.controller.TrainingController;
import com.training.jpacrud.service.TrainingService;



@ExtendWith(MockitoExtension.class)
public class TrainingControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	TrainingController trainingControler;

	@Mock
	TrainingService trainingService;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(trainingControler).build();
	}

	@Test
	public void showAddTrainingPage() throws Exception {
		mockMvc.perform(get("/addTraining").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(view().name("addTrainingPage"))
				.andDo(MockMvcResultHandlers.print());
	}


	@Test
	public void showlistTrainingPage() throws Exception {
		mockMvc.perform(get("/listTrainings").contentType(MediaType.APPLICATION_JSON).param("pageNumber","0"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(view().name("listTrainingPage"))
				.andDo(MockMvcResultHandlers.print());
	}


	
	
	@Test
	public void showEditTrainingPage() throws Exception {
		mockMvc.perform(get("/editTraining").contentType(MediaType.APPLICATION_JSON)
		.param("id","1"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(view().name("editTrainingPage"))
				.andDo(MockMvcResultHandlers.print());
	}
	
	
	@Test
	public void addTrainingPage() throws Exception {

		mockMvc.perform(post("/addTraining").contentType(MediaType.APPLICATION_JSON).param("id", "0")
				.param("name", "Java").param("startDate", "2021-10-16").param("endDate", "2021-10-16")
				.param("fee", "1000").param("gst", "18").param("personsAllowed", "31").param("personsNominated", "31")
				.param("trainerName", "A").param("skills", "Java")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(view().name("listTrainingPage")).andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void addTrainingErrorPage() throws Exception {

		mockMvc.perform(post("/addTraining").contentType(MediaType.APPLICATION_JSON).param("id", "0").param("name", "")
				.param("fee", "1").param("gst", "-8").param("personsAllowed", "1000").param("personsNominated", "31")
				.param("trainerName", "").param("skills", "Java")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(view().name("addTrainingPage")).andDo(MockMvcResultHandlers.print());
	}

	
	@Test
	public void editTrainingPage() throws Exception {

		mockMvc.perform(post("/editTraining").contentType(MediaType.APPLICATION_JSON).param("id", "0")
				.param("name", "Java").param("startDate", "2021-10-16").param("endDate", "2021-10-16")
				.param("fee", "1000").param("gst", "18").param("personsAllowed", "31").param("personsNominated", "31")
				.param("trainerName", "A").param("skills", "Java")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(view().name("listTrainingPage")).andDo(MockMvcResultHandlers.print());
	}
	
	
	@Test
	public void editTrainingErrorPage() throws Exception {

		mockMvc.perform(post("/editTraining").contentType(MediaType.APPLICATION_JSON).param("id", "0").param("name", "")
				.param("fee", "1").param("gst", "-8").param("personsAllowed", "1000").param("personsNominated", "31")
				.param("trainerName", "").param("skills", "Java")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(view().name("editTrainingPage")).andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void deleteTrainingPage() throws Exception {
		mockMvc.perform(get("/deleteTraining").contentType(MediaType.APPLICATION_JSON)
		.param("id","1"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(view().name("listTrainingPage"))
				.andDo(MockMvcResultHandlers.print());
	}

	public static String asJsonString(final Object obj) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.registerModule(new JavaTimeModule());
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}