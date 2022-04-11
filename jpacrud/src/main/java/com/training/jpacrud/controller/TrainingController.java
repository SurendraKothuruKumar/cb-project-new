package com.training.jpacrud.controller;




import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.jpacrud.model.Training;
import com.training.jpacrud.service.TrainingService;




@Controller
public class TrainingController {
	
	@Autowired
	TrainingService trainService;
	
	@GetMapping("/listTrainings")
	public  String listTrainings(ModelMap model, @RequestParam(required = false, defaultValue = "0") int pageNumber) {
		model.addAttribute("trainingList",trainService.listTrainings(pageNumber));
		 return "listTrainingPage";
		
		}
	@GetMapping("/addTraining")
	public  ModelAndView showAddTraining(ModelMap model) {
		return new ModelAndView("addTrainingPage","Training",new Training());
		
		
		}
	
	@PostMapping("/addTraining")
	public  ModelAndView addTraining(@Valid @ModelAttribute("Training") Training training ,BindingResult result) {
		ModelAndView  mv=new ModelAndView();
		if(result.hasErrors())
		{
			mv.setViewName("addTrainingPage");
		}else {
		trainService.addtraining(training);
		mv.addObject("trainingList",trainService.listTrainings(0));
		mv.addObject("msg","successfully added");
		mv.setViewName("listTrainingPage");
		}
		return mv;
		
		}
	@GetMapping("/editTraining")
	public  ModelAndView showEditTraining(@RequestParam int id) {
		return new ModelAndView("editTrainingPage","Training",trainService.getTrainingById(id));
		
		
		}
	
	@PostMapping("/editTraining")
	public  ModelAndView editTraining(@Valid @ModelAttribute("Training") Training training ,BindingResult result) {
		ModelAndView  mv=new ModelAndView();
		if(result.hasErrors())
		{
			mv.setViewName("editTrainingPage");
		}else {
		trainService.addtraining(training);
		mv.addObject("trainingList",trainService.listTrainings(0));
		mv.addObject("msg","successfully updated");
		mv.setViewName("listTrainingPage");
		}
		return mv;
		
		}
	@GetMapping("/deleteTraining")
	public  ModelAndView  deleteTraining(@RequestParam int id) {
		ModelAndView  mv=new ModelAndView();
		trainService.deleteTrainingById(id);
		mv.addObject("trainingList",trainService.listTrainings(0));
		mv.addObject("msg","successfully deleted");
		mv.setViewName("listTrainingPage");
		
		return mv;
		}
		
}
