package com.sec.ma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sec.ma.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	@Query("SELECT COUNT(*) from Client")
	int countClient();
}
