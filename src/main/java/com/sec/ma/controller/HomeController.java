package com.sec.ma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sec.ma.entities.User;
import com.sec.ma.service.EntrepriseService;
import com.sec.ma.service.UserService;

@RestController
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private EntrepriseService entrepriseService;
	
	
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user",user);
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	
	@GetMapping("/home")
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("countUser", userService.countUser());
		modelAndView.addObject("countEntr", entrepriseService.countEntr());
		modelAndView.setViewName("index");
		return modelAndView;
    }
	
	@GetMapping("/clientDetails")
	public ModelAndView client() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("clientDetails");
		return modelAndView;
	}
	
	@GetMapping("/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("forbidden");
		return modelAndView;
	}
	
	@GetMapping("/error")
	public ModelAndView error() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		return modelAndView;
	}
	
}
