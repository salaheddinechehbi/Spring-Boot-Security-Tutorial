package com.sec.ma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sec.ma.entities.Categorie;
import com.sec.ma.repository.CategorieRepository;

@Service
public class CategorieService {
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	

	public void save(Categorie categorie) {
		
		categorieRepository.save(categorie);		
	}
	
	public void delete(int id) {
		
		categorieRepository.deleteById(id);		
	}

	public List<Categorie> findAll() {
		
		return categorieRepository.findAll();
	}
	
	public int countCat() {
		
		return categorieRepository.countCategorie();
	}
	
	public Categorie findById(int id) {
		
		return categorieRepository.findById(id).get();
	}

}
