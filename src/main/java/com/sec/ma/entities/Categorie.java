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
@Table(name = "categorie_data")
@Data @NoArgsConstructor @AllArgsConstructor @ToString 
public class Categorie {

	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	@NotNull(message="Libelle is empthy")
	@Column(name="libelle_agence")
	private String libelle;
}
