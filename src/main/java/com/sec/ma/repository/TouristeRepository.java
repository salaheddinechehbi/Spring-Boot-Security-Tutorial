package com.sec.ma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sec.ma.entities.Touriste;

@Repository
public interface TouristeRepository extends JpaRepository<Touriste, Integer> {

	@Query("SELECT COUNT(*) from Touriste")
	int countTouriste();
	
}
