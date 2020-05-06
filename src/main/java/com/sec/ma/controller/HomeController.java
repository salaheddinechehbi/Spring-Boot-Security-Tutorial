package com.sec.ma.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping(value = "/")
	public String hello() {
		return "Welcome to Spring Security tutorial :) ";
	}
	
	@GetMapping(value = "/user")
	public String user() {
		return "Welcome to Spring Security tutorial :) User";
	}
	
	@GetMapping(value = "/admin")
	public String admin() {
		return "Welcome to Spring Security tutorial :) Admin";
	}
	
}
