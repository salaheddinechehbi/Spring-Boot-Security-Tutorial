package com.sec.ma.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sec.ma.entities.Entreprise;
import com.sec.ma.service.EntrepriseService;
import com.sec.ma.service.UserService;
import com.sec.ma.entities.Contrat;
import com.sec.ma.service.ContratService;

@RestController
@RequestMapping("/contratDetails")
public class ContratController {

	@Autowired
	private EntrepriseService entrepriseService;
	@Autowired
	private ContratService contratService;
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ModelAndView contrat() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("contrat", new Contrat());
		modelAndView.addObject("listEntr", entrepriseService.findAll());
		modelAndView.addObject("listCont", contratService.findAll());
		modelAndView.addObject("listUser", userService.findAll());
		modelAndView.setViewName("contratDetails");
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView addContrat( HttpServletRequest request,BindingResult bindingResult) throws ParseException {
		ModelAndView modelAndView = new ModelAndView();
		// Check for the validations
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in form!");
		}else {
			Contrat contrat = new Contrat();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date dateSigne = format.parse(request.getParameter("dateSigne"));
            Date dateDebut = format.parse(request.getParameter("dateDebut"));
            Date dateFin = format.parse(request.getParameter("dateFin"));
			contrat.setDateSigne(dateSigne);;
			contrat.setDateDebut(dateDebut);;
			contrat.setDateFin(dateFin);
			contrat.setEntreprise(entrepriseService.findById(Integer.parseInt(request.getParameter("idE"))));
			contrat.setUser(userService.findById(Integer.parseInt(request.getParameter("idU"))));
		    
			contratService.save(contrat);
			modelAndView.addObject("successMessage", "Ajouter");
		}
		modelAndView.addObject("contrat", new Contrat());
		modelAndView.addObject("listEntr", entrepriseService.findAll());
		modelAndView.addObject("listCont", contratService.findAll());
		modelAndView.addObject("listUser", userService.findAll());
		modelAndView.setViewName("contratDetails");
		
		return modelAndView;
	}
	
	@PostMapping("/update")
	public ModelAndView updateContrat(HttpServletRequest request,RedirectAttributes redir) throws ParseException {
		ModelAndView modelAndView = new ModelAndView("redirect:/contratDetails");
		Contrat contrat = new Contrat();
		try{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date dateSigne = format.parse(request.getParameter("dateSigne"));
            Date dateDebut = format.parse(request.getParameter("dateDebut"));
            Date dateFin = format.parse(request.getParameter("dateFin"));
			contrat.setDateSigne(dateSigne);;
			contrat.setDateDebut(dateDebut);;
			contrat.setDateFin(dateFin);
			contrat.setEntreprise(entrepriseService.findById(Integer.parseInt(request.getParameter("idE"))));
			contrat.setUser(userService.findById(Integer.parseInt(request.getParameter("idU"))));
		    
			contratService.save(contrat);
			redir.addFlashAttribute("successMessage", "Modifier");
		} catch(NumberFormatException ex){ // handle your exception
			
		}
		return modelAndView;
	}
	
	
	@PostMapping("/delete")
	public ModelAndView deleteContrat(HttpServletRequest request,RedirectAttributes redir) {
		ModelAndView modelAndView = new ModelAndView("redirect:/contratDetails");
		int id = Integer.parseInt(request.getParameter("idE"));
		contratService.delete(id);
		redir.addFlashAttribute("successMessage", "Supprimer");
		return modelAndView;
	}
	
	
	@PostMapping(value = "/findById", produces = "application/json")
	public Contrat findById(@RequestParam  String idE) {
		//(required = false)
		//(defaultValue = "test")
		int id = Integer.parseInt(idE);
		return contratService.findById(id);
	}
	
	
	
	//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	//User customUser = (User)authentication.getPrincipal();
	//int userId = customUser.getId();
	
	
	//(Principal principal) { return principal.getName();
	//(Authentication authentication) {  return authentication.getName();
	
	
	
	@GetMapping(value = "/findById", produces = "application/json")
	public Entreprise findById2(@RequestParam  String idE) {
		//(required = false)
		//(defaultValue = "test")
		int id = Integer.parseInt(idE);
		return entrepriseService.findById(id);
	}
	
	
	
	
	
}
