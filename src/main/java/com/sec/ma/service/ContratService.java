package com.sec.ma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sec.ma.entities.Contrat;
import com.sec.ma.repository.ContratRepository;

@Service
public class ContratService {
	
	@Autowired
	private ContratRepository contratRepository;
	
	

	public void save(Contrat contrat) {
		
		contratRepository.save(contrat);		
	}
	
	public void delete(int id) {
		
		contratRepository.deleteById(id);		
	}

	public List<Contrat> findAll() {
		
		return contratRepository.findAll();
	}
	
	public int countContrat() {
		
		return contratRepository.countContrat();
	}

	public Contrat findById(int id) {
		return contratRepository.findById(id).get();
	}
}
