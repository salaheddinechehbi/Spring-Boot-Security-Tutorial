package com.sec.ma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sec.ma.entities.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Integer> {

	@Query("SELECT COUNT(*) from Contrat")
	int countContrat();
}
