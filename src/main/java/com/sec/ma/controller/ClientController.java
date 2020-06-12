package com.sec.ma.controller;

import java.util.List;

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

import com.sec.ma.entities.Client;
import com.sec.ma.service.ClientService;
import com.sec.ma.service.EntrepriseService;

@RestController
@RequestMapping("/clientDetails")
public class ClientController {

	@Autowired
	private EntrepriseService entrepriseService;
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public ModelAndView client() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("client", new Client());
		modelAndView.addObject("listEntr", entrepriseService.findAll());
		modelAndView.addObject("listClient", clientService.findAll());
		modelAndView.setViewName("clientDetails");
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView addClient(@Valid Client client, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		// Check for the validations
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in form!");
		}else {
			clientService.save(client);
			modelAndView.addObject("successMessage", "Ajouter");
		}
		modelAndView.addObject("client", new Client());
		modelAndView.addObject("listEntr", entrepriseService.findAll());
		modelAndView.addObject("listClient", clientService.findAll());
		modelAndView.setViewName("clientDetails");
		
		return modelAndView;
	}
	
	@PostMapping("/update")
	public ModelAndView updateClient(HttpServletRequest request,RedirectAttributes redir) {
		ModelAndView modelAndView = new ModelAndView("redirect:/clientDetails");
		Client client = new Client();
		try{
			
			client.setNom(request.getParameter("nom"));
			client.setEmail(request.getParameter("email"));
			client.setTele(request.getParameter("tele"));
			client.setFonction(request.getParameter("fonction"));
			client.setEntreprise(entrepriseService.findById(Integer.parseInt(request.getParameter("entreprise"))));
			client.setId(Integer.parseInt(request.getParameter("idCl")));
		    
			clientService.save(client);
			redir.addFlashAttribute("successMessage", "Modifier");
		} catch(NumberFormatException ex){ // handle your exception
		    System.out.println("Format id " + client.getNom() + "  :  " + client.getId());
		}
		return modelAndView;
	}
	
	
	@PostMapping("/delete")
	public ModelAndView deleteClient(HttpServletRequest request,RedirectAttributes redir) {
		ModelAndView modelAndView = new ModelAndView("redirect:/clientDetails");
		int id = Integer.parseInt(request.getParameter("idCl"));
		clientService.delete(id);
		redir.addFlashAttribute("successMessage", "Supprimer");
		return modelAndView;
	}
	
	@PostMapping(value = "/findByEntr", produces = "application/json")
	public List<Client> findByEntr(@RequestParam  String idE) {
		//(required = false)
		//(defaultValue = "test")
		int id = Integer.parseInt(idE);
		return clientService.findByEntr(id);
	}
	
	
}
