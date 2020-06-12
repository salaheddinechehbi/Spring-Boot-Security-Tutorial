package com.sec.ma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sec.ma.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	@Query("SELECT COUNT(*) from Client")
	int countClient();
	
	@Query("SELECT c from Client c WHERE c.entreprise.id=:idE")
	List<Client> clientByEntr(@Param("idE") int idE);
}
