package com.sec.ma.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sec.ma.entities.User;

@Repository
public interface UserReporitory extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String userName);
	
	/*
	@Modifying(clearAutomatically = true)
	@Query("update RssFeedEntry feedEntry set feedEntry.read =:isRead where feedEntry.id =:entryId")
	void markEntryAsRead(@Param("entryId") Long rssFeedEntryId, @Param("isRead") boolean isRead);
	*/
	
	@Modifying
	@Transactional 
	@Query("UPDATE User u SET u.email=:email,u.active=:active,u.roles=:roles where u.id=:id")
	void updateUser(@Param("email") String email,@Param("active") boolean active,@Param("roles") String roles,@Param("id") int id);
	
	@Query("SELECT COUNT(*) from User u WHERE u.active=true")
	int countUser();
	
	
}
