package com.sec.ma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sec.ma.repository.UserReporitory;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.sec.ma.entities"}) 
@EnableJpaRepositories(basePackageClasses = UserReporitory.class)
public class SpringBootSecurity1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurity1Application.class, args);
		
	}

}
