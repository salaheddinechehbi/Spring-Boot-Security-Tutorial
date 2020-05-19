package com.sec.ma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "user_data")
@Data @NoArgsConstructor @AllArgsConstructor @ToString 
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message="Nom is empthy")
	private String nom;
	@NotNull(message="Tele is empthy")
	private String tele;
	@NotNull(message="Email is empthy")
	@javax.validation.constraints.Email(message="Email is Invalide")
	private String email;
	@NotNull(message="Username is empthy")
	private String username;
	@NotNull(message="Password is empthy")
	@Length(min=6,message="Password must be at least 6 caracteres")
	private String password;
	@NotNull(message="Active is empthy")
	private boolean active;
	@NotNull(message="Role is empthy")
	private String roles;
	
	
}
