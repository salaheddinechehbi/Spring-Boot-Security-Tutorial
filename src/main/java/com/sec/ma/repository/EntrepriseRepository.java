package com.sec.ma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sec.ma.entities.Entreprise;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

	
	@Query("SELECT COUNT(*) from Entreprise")
	int countEntr();
	
	
}
