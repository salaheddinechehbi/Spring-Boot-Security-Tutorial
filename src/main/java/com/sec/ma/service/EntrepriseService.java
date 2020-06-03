package com.sec.ma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sec.ma.entities.Entreprise;
import com.sec.ma.repository.EntrepriseRepository;

@Service
public class EntrepriseService {
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	

	public void save(Entreprise entreprise) {
		
		entrepriseRepository.save(entreprise);		
	}
	
	public void delete(int id) {
		
		entrepriseRepository.deleteById(id);		
	}

	public List<Entreprise> findAll() {
		
		return entrepriseRepository.findAll();
	}
	
	public int countEntr() {
		
		return entrepriseRepository.countEntr();
	}

}
