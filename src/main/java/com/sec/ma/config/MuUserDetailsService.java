package com.sec.ma.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sec.ma.repository.UserReporitory;

public class MuUserDetailsService implements UserDetailsService {

	@Autowired
	UserReporitory userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return new MyUserDetail(userName);
	}

}
