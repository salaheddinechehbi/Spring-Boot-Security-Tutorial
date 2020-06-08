package com.sec.ma.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "touriste_data")
@Data @NoArgsConstructor @AllArgsConstructor @ToString 
public class Touriste {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message="Nom is empthy")
	@Column(name="nom_touriste")
	private String nom;
	@NotNull(message="Email is empthy")
	@Column(name="email_touriste")
	private String email;
	@NotNull(message="Tele is empthy")
	@Column(name="tele_touriste")
	private String tele;
	@NotNull(message="Ville is empthy")
	@Column(name="ville_touriste")
	private String Ville;
	@NotNull(message="Country is empthy")
	@Column(name="country_touriste")
	private String country;
}
