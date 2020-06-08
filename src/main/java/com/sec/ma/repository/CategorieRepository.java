package com.sec.ma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sec.ma.entities.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

	@Query("SELECT COUNT(*) from Categorie")
	int countCategorie();
}
