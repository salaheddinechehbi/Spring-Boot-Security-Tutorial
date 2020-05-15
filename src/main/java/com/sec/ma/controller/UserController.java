package com.sec.ma.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sec.ma.entities.User;
import com.sec.ma.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		// Check for the validations
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in form!");
			modelMap.addAttribute("bindingResult", bindingResult);
		}else {
			userService.save(user);
			modelAndView.addObject("successMessage", "User is registered successfully!");
		}
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	@GetMapping("/userDetails")
	public ModelAndView findAllUser() {
		ModelAndView modelAndView = new ModelAndView();
		//PrintStream out = System.out;System.setOut(out);
		//System.out.println("*********************************************************************************");
		//System.out.println(userService.findAll());
		//System.out.println("*********************************************************************************");
		modelAndView.addObject("successMes", "Please correct");
		modelAndView.addObject("listUsers", userService.findAll());
		//modelMap.addAttribute("list", userService.findAll());
		modelAndView.setViewName("userDetails");
		return modelAndView;
	}
	
	@GetMapping("/userD")
	public String findUser(Model model) {
		model.addAttribute("successMes", "Please correct");
		return "userDetails";
	}
	
	
}
