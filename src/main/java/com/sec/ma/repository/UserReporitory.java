package com.sec.ma.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sec.ma.entities.User;

public interface UserReporitory extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String userName);
	
}
