package com.sec.ma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "user_data")
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", username=" + username + ", roles=" + roles + "]";
	}
	
	
	
}
