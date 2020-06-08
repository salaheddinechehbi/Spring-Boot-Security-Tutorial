package com.sec.ma.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "agence_data")
@Data @NoArgsConstructor @AllArgsConstructor @ToString 
public class Entreprise {

	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	@NotNull(message="Libelle is empthy")
	@Column(name="libelle_agence")
	private String libelle;
	@NotNull(message="Adresse is empthy")
	@Column(name="adresse_agence")
	private String adresse;
	@NotNull(message="Tele is empthy")
	@Column(name="tele_agence")
	private String tele;
	@NotNull(message="Email is empthy")
	@Column(name="email_agence")
	private String email;
	@NotNull(message="Ville is empthy")
	@Column(name="ville_agence")
	private String ville;
	@ManyToOne(fetch = FetchType.EAGER)
	private Categorie categorie;
	
	
	
}
