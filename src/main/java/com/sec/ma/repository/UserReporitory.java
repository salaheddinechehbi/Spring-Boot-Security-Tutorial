package com.sec.ma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sec.ma.entities.User;

public interface UserReporitory extends JpaRepository<User, Integer>{

}
