package com.sec.ma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sec.ma.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
