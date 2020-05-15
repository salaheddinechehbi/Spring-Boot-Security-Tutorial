package com.sec.ma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EntrepriseController {

	@Autowired
	private EntrepriseController entrepriseController;
	
	@GetMapping("/entrDetails")
	public ModelAndView entreprise() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("successEnt", "Please correct");
		modelAndView.setViewName("entrDetails");
		return modelAndView;
	}
	
	
}
