package com.sec.ma.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SeurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//here when we add the allowed user to authenticate to our application
		//here we create users in memory not from database
		
		/*
		auth.inMemoryAuthentication()
			.withUser("user")
			.password("{noop}1235")
			.roles("USER")
		.and()
			.withUser("admin")
			.password("{noop}1236")
			.roles("ADMIN");
			*/
		
		auth.userDetailsService(userDetailsService);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*http.authorizeRequests()
			.antMatchers("/**").hasRole("ADMIN")//here we give the access only to user with role ADMIN and he have access to all url path with /**
			.and()
			.formLogin();*/
		
		/*
		 http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")//the admin path should be accessing only to ADMIN user
		.antMatchers("/user").hasRole("USER")//the user path should be accessing only to USER user
		.antMatchers("/","static/css","static/js").permitAll()//we this we tell spring to return this pages however is user login or not
		.and()
		.formLogin();
		*/
		
		
		http.authorizeRequests()
		.antMatchers("/admin","/register","/userDetails").hasRole("ADMIN")//the admin path should be accessing only to ADMIN user
		.antMatchers("/user","/home").hasAnyRole("USER","ADMIN")//the user path should be accessing only to USER user
		.antMatchers("/","static/css","static/plugins","static/js").permitAll()//we this we tell spring to return this pages however is user login or not, or we use only /
		.and()
		.formLogin();
		
		//.formLogin().loginPage("/login");
		//we have to respect the order of heiher role to lower
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	
	

	
}
