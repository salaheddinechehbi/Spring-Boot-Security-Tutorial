package com.sec.ma.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sec.ma.entities.User;
import com.sec.ma.service.UserService;

@RestController
@RequestMapping("/userDetails")
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
	
	@GetMapping
	public ModelAndView user() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listUsers", userService.findAll());
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("userDetails");
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView registerU(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		// Check for the validations
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in form!");
			modelMap.addAttribute("bindingResult", bindingResult);
		}else {
			userService.save(user);
			modelAndView.addObject("successMessage", "Ajouter");
		}
		modelAndView.addObject("user", new User());
		modelAndView.addObject("listUsers", userService.findAll());
		modelAndView.setViewName("userDetails");
		return modelAndView;
	}
	
	@PostMapping("/delete")
	public ModelAndView deleteUser(HttpServletRequest request,RedirectAttributes redir) {
		ModelAndView modelAndView = new ModelAndView("redirect:/userDetails");
		int id = Integer.parseInt(request.getParameter("idU"));
		userService.delete(id);
		redir.addFlashAttribute("successMessage", "Supprimer");
		return modelAndView;
	}
	
	@PostMapping("/update")
	public ModelAndView updateUser(HttpServletRequest request,RedirectAttributes redir) {
		ModelAndView modelAndView = new ModelAndView("redirect:/userDetails");
		int id = Integer.parseInt(request.getParameter("idU"));
		boolean active = Boolean.parseBoolean(request.getParameter("active"));
		String nom = request.getParameter("nom");
		String tele = request.getParameter("tele");
		String email = request.getParameter("email");
		String roles = request.getParameter("role");
		userService.updateUser(nom, email, active, roles, tele, id);
		redir.addFlashAttribute("successMessage", "Modifier");
		return modelAndView;
	}
	
	@PostMapping("/update2")
	public ModelAndView updateUser2(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("redirect:/userDetails");
		int id = Integer.parseInt(request.getParameter("idU"));
		boolean active = Boolean.parseBoolean(request.getParameter("active"));
		String nom = request.getParameter("nom");
		String tele = request.getParameter("tele");
		String email = request.getParameter("email");
		String roles = request.getParameter("role");
		User user = new User();
		user = userService.findById(id);
		user.setId(id);
		user.setEmail(email);
		user.setNom(nom);
		user.setRoles(roles);
		user.setTele(tele);
		user.setActive(active);
		
		userService.save(user);
		return modelAndView;
	}
	
	
	
	
	
}
