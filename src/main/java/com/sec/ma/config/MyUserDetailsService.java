package com.sec.ma.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sec.ma.entities.User;
import com.sec.ma.repository.UserReporitory;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserReporitory userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = userRepo.findByUsername(userName);
		return user.map(MyUserDetails::new).get();
	}

}
