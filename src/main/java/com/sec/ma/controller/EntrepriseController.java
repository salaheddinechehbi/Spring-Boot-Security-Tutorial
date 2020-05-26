package com.sec.ma.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sec.ma.entities.Entreprise;
import com.sec.ma.service.EntrepriseService;

@RestController
@RequestMapping("/entrDetails")
public class EntrepriseController {

	@Autowired
	private EntrepriseService entrepriseService;
	
	@GetMapping
	public ModelAndView entreprise() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("entreprise", new Entreprise());
		modelAndView.addObject("listEntr", entrepriseService.findAll());
		modelAndView.setViewName("entrDetails");
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView addEntreprise(@Valid Entreprise entreprise, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		// Check for the validations
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in form!");
			modelMap.addAttribute("bindingResult", bindingResult);
		}else {
			entrepriseService.save(entreprise);
			modelAndView.addObject("successMessage", "Entreprise is registered successfully!");
		}
		modelAndView.addObject("entreprise", new Entreprise());
		modelAndView.addObject("listEntr", entrepriseService.findAll());
		modelAndView.setViewName("entrDetails");
		
		return modelAndView;
	}
	
	@PostMapping("/update")
	public ModelAndView updateEntreprise(@Valid Entreprise entreprise, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		// Check for the validations
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in form!");
			modelMap.addAttribute("bindingResult", bindingResult);
		}else {
			entrepriseService.save(entreprise);
			modelAndView.addObject("successMessage", "Entreprise is registered successfully!");
		}
		modelAndView.addObject("entreprise", new Entreprise());
		modelAndView.addObject("listEntr", entrepriseService.findAll());
		modelAndView.setViewName("entrDetails");
		
		return modelAndView;
	}
	
	
	@PostMapping("/delete")
	public ModelAndView deleteEntr(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("redirect:/entrDetails");
		int id = Integer.parseInt(request.getParameter("idE"));
		entrepriseService.delete(id);
		modelAndView.addObject("successMessage", "Enteprise Deleted");
		return modelAndView;
	}
	
	
}
