package com.sec.ma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sec.ma.entities.User;

@RestController
public class HomeController {

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
		modelAndView.setViewName("index");
		return modelAndView;
    }
	
	@GetMapping("/userDetails")
	public ModelAndView user() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userDetails");
		return modelAndView;
	}
	
	@GetMapping("/entrDetails")
	public ModelAndView entreprise() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("entrDetails");
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
