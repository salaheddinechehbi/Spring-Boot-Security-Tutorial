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

import com.sec.ma.entities.Touriste;
import com.sec.ma.service.TouristeService;

@RestController
@RequestMapping("/tourDetails")
public class TouristeController {

	@Autowired
	private TouristeService touristeService;
	
	@GetMapping
	public ModelAndView entreprise() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("touriste", new Touriste());
		modelAndView.addObject("listTour", touristeService.findAll());
		modelAndView.setViewName("touristeDetails");
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView addTouriste(@Valid Touriste touriste, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		// Check for the validations
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in form!");
		}else {
			touristeService.save(touriste);
			modelAndView.addObject("successMessage", "Ajouter");
		}
		modelAndView.addObject("touriste", new Touriste());
		modelAndView.addObject("listTour", touristeService.findAll());
		modelAndView.setViewName("touristeDetails");
		
		return modelAndView;
	}
	
	@PostMapping("/update")
	public ModelAndView updateTouriste(HttpServletRequest request,RedirectAttributes redir) {
		ModelAndView modelAndView = new ModelAndView("redirect:/tourDetails");
		Touriste touriste = new Touriste();
		try{
			
			touriste.setNom(request.getParameter("nom"));
			touriste.setEmail(request.getParameter("email"));
			touriste.setTele(request.getParameter("tele"));
			touriste.setCountry(request.getParameter("country"));
			touriste.setVille(request.getParameter("ville"));
			touriste.setId(Integer.parseInt(request.getParameter("idT")));
		    
			touristeService.save(touriste);
			redir.addFlashAttribute("successMessage", "Modifier");
		} catch(NumberFormatException ex){ // handle your exception
		    System.out.println("Format id " + touriste.getNom() + "  :  " + touriste.getId());
		}
		return modelAndView;
	}
	
	
	@PostMapping("/delete")
	public ModelAndView deleteTouriste(HttpServletRequest request,RedirectAttributes redir) {
		ModelAndView modelAndView = new ModelAndView("redirect:/tourDetails");
		int id = Integer.parseInt(request.getParameter("idT"));
		touristeService.delete(id);
		redir.addFlashAttribute("successMessage", "Supprimer");
		return modelAndView;
	}
	
	
}
