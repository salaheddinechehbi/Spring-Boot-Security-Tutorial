package com.sec.ma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sec.ma.entities.User;
import com.sec.ma.repository.UserReporitory;

@Service
public class UserService {

	@Autowired
	private UserReporitory userReporitory;
	
	public void save(User user) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword("pass0011");
		String pass = encoder.encode(user.getPassword());
		user.setPassword(pass);
		userReporitory.save(user);
	}
	
	public void updateUser(String nom,String email,boolean active,String roles,String tele,int id) {
		
		userReporitory.updateUser(nom, email, active, roles, tele, id);
	}
	
	public List<User> findAll() {
		
		return userReporitory.findAll();
	}
	
	public User findById(int id) {
		
		return userReporitory.findById(id).get();
	}
	
	public void delete(int id) {
		
		userReporitory.deleteById(id);
	}
	
}
