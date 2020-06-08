package com.sec.ma.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sec.ma.entities.Categorie;
import com.sec.ma.service.CategorieService;

@RestController
@RequestMapping("/catDetails")
public class CategorieController {

	@Autowired
	private CategorieService categorieService;
	
	@GetMapping
	public ModelAndView categorie() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("categorie", new Categorie());
		modelAndView.addObject("listCat", categorieService.findAll());
		modelAndView.setViewName("catDetails");
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView addEntreprise(@Valid Categorie categorie, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		// Check for the validations
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in form!");
		}else {
			categorieService.save(categorie);
			modelAndView.addObject("successMessage", "Ajouter");
		}
		modelAndView.addObject("categorie", new Categorie());
		modelAndView.addObject("listCat", categorieService.findAll());
		modelAndView.setViewName("catDetails");
		
		return modelAndView;
	}
	
	@PostMapping("/update")
	public ModelAndView updateEntreprise(HttpServletRequest request,RedirectAttributes redir) {
		ModelAndView modelAndView = new ModelAndView("redirect:/catDetails");
		Categorie categorie = new Categorie();
		try{
			
			categorie.setLibelle(request.getParameter("libelle"));
			categorie.setId(Integer.parseInt(request.getParameter("idC")));
		    
		    categorieService.save(categorie);
			redir.addFlashAttribute("successMessage", "Modifier");
		} catch(NumberFormatException ex){ // handle your exception
		    System.out.println("Format id " + categorie.getLibelle() + "  :  " + categorie.getId());
		}
		return modelAndView;
	}
	
	
	@PostMapping("/delete")
	public ModelAndView deleteCat(HttpServletRequest request,RedirectAttributes redir) {
		ModelAndView modelAndView = new ModelAndView("redirect:/catDetails");
		int id = Integer.parseInt(request.getParameter("idC"));
		categorieService.delete(id);
		redir.addFlashAttribute("successMessage", "Supprimer");
		return modelAndView;
	}
	
	
}
