package com.sec.ma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="client_data")
public class Client {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message="Nom is empthy")
	private String nom;
	@NotNull(message="Email is empthy")
	private String email;
	@NotNull(message="Fonction is empthy")
	private String fonction;
	@NotNull(message="Email is empthy")
	private String roles;
	
	
	
}
