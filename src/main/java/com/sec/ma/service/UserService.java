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
	
	public void updateUser(String email,boolean active,String roles,int id) {
		
		userReporitory.updateUser(email, active, roles, id);
	}
	
	public List<User> findAll() {
		
		return userReporitory.findAll();
	}
	
	public User findById(int id) {
		
		return userReporitory.findById(id).get();
	}
	
	public User findByUserName(String uname) {
		
		return userReporitory.findByUsername(uname).get();
	}
	
	public void delete(int id) {
		
		userReporitory.deleteById(id);
	}
	
	public int countUser() {
		
		return userReporitory.countUser();
	}
	
}
