package com.sec.ma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sec.ma.entities.Touriste;
import com.sec.ma.repository.TouristeRepository;

@Service
public class TouristeService {
	
	@Autowired
	private TouristeRepository touristeRepository;
	
	

	public void save(Touriste touriste) {
		
		touristeRepository.save(touriste);		
	}
	
	public void delete(int id) {
		
		touristeRepository.deleteById(id);		
	}

	public List<Touriste> findAll() {
		
		return touristeRepository.findAll();
	}
	
	public int countTouriste() {
		
		return touristeRepository.countTouriste();
	}

}
