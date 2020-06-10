package com.sec.ma.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "client_data")
@Data @NoArgsConstructor @AllArgsConstructor @ToString 
public class Client {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message="Nom is empthy")
	@Column(name="nom_client")
	private String nom;
	@NotNull(message="Email is empthy")
	@Column(name="email_client")
	private String email;
	@NotNull(message="Tele is empthy")
	@Column(name="tele_client")
	private String tele;
	@NotNull(message="Fonction is empthy")
	@Column(name="fonction_client")
	private String fonction;
	@OneToOne(fetch = FetchType.EAGER)
	private Entreprise entreprise; 
	
	
	
}
