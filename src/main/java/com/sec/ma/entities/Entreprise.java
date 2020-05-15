package com.sec.ma.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "agence_data")
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
	public Entreprise() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Entreprise [id=" + id + ", libelle=" + libelle + "]";
	}
	
	
	
	
	
}
