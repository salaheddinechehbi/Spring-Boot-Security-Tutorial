package com.sec.ma.controller;

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
import com.sec.ma.service.CategorieService;
import com.sec.ma.service.EntrepriseService;

@RestController
@RequestMapping("/entrDetails")
public class EntrepriseController {

	@Autowired
	private EntrepriseService entrepriseService;
	@Autowired
	private CategorieService categorieService;
	
	@GetMapping
	public ModelAndView entreprise() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("entreprise", new Entreprise());
		modelAndView.addObject("listEntr", entrepriseService.findAll());
		modelAndView.addObject("listCat", categorieService.findAll());
		modelAndView.setViewName("entrDetails");
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView addEntreprise(@Valid Entreprise entreprise, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		// Check for the validations
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in form!");
		}else {
			entrepriseService.save(entreprise);
			modelAndView.addObject("successMessage", "Ajouter");
		}
		modelAndView.addObject("entreprise", new Entreprise());
		modelAndView.addObject("listEntr", entrepriseService.findAll());
		modelAndView.addObject("listCat", categorieService.findAll());
		modelAndView.setViewName("entrDetails");
		
		return modelAndView;
	}
	
	@PostMapping("/update")
	public ModelAndView updateEntreprise(HttpServletRequest request,RedirectAttributes redir) {
		ModelAndView modelAndView = new ModelAndView("redirect:/entrDetails");
		Entreprise entreprise = new Entreprise();
		try{
			
			entreprise.setLibelle(request.getParameter("libelle"));
			entreprise.setEmail(request.getParameter("email"));
			entreprise.setTele(request.getParameter("tele"));
			entreprise.setAdresse(request.getParameter("adresse"));
			entreprise.setVille(request.getParameter("ville"));
			entreprise.setCategorie(categorieService.findById(Integer.parseInt(request.getParameter("categorie"))));
		    entreprise.setId(Integer.parseInt(request.getParameter("idE")));
		    
			entrepriseService.save(entreprise);
			redir.addFlashAttribute("successMessage", "Modifier");
		} catch(NumberFormatException ex){ // handle your exception
		    System.out.println("Format id " + entreprise.getLibelle() + "  :  " + entreprise.getId());
		}
		return modelAndView;
	}
	
	
	@PostMapping("/delete")
	public ModelAndView deleteEntr(HttpServletRequest request,RedirectAttributes redir) {
		ModelAndView modelAndView = new ModelAndView("redirect:/entrDetails");
		int id = Integer.parseInt(request.getParameter("idE"));
		entrepriseService.delete(id);
		redir.addFlashAttribute("successMessage", "Supprimer");
		return modelAndView;
	}
	
	
	@PostMapping(value = "/findById", produces = "application/json")
	public Entreprise findById(@RequestParam  String idE) {
		//(required = false)
		//(defaultValue = "test")
		int id = Integer.parseInt(idE);
		return entrepriseService.findById(id);
	}
	
	
	
	
	
	
	
	
	
	
	@GetMapping(value = "/findById", produces = "application/json")
	public Entreprise findById2(@RequestParam  String idE) {
		//(required = false)
		//(defaultValue = "test")
		int id = Integer.parseInt(idE);
		return entrepriseService.findById(id);
	}
	
	
	
	
	
}
