package com.sec.ma.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sec.ma.entities.User;

@Repository
public interface UserReporitory extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String userName);
	
}
