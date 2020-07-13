package com.sec.ma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sec.ma.config.MyUserDetails;
import com.sec.ma.entities.User;
import com.sec.ma.service.ClientService;
import com.sec.ma.service.EntrepriseService;
import com.sec.ma.service.TouristeService;
import com.sec.ma.service.UserService;

@RestController
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private EntrepriseService entrepriseService;
	@Autowired
	private TouristeService touristeService;
	@Autowired
	private ClientService clientService;
	
	
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
		modelAndView.addObject("countTour", touristeService.countTouriste());
		modelAndView.addObject("countClient", clientService.countClient());
		
		modelAndView.setViewName("index");
		return modelAndView;
    }
	
	@GetMapping("/")
	public ModelAndView index2(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("countUser", userService.countUser());
		modelAndView.addObject("countEntr", entrepriseService.countEntr());
		modelAndView.addObject("countTour", touristeService.countTouriste());
		modelAndView.addObject("countClient", clientService.countClient());
		modelAndView.setViewName("index");
		return modelAndView;
    }
	
	@GetMapping("/findInfo")
	public User findInfo() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUserDetails customUser = (MyUserDetails)authentication.getPrincipal();
		String uname = customUser.getUsername();
		return userService.findByUserName(uname);
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
