package com.sec.ma.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "contrat_data")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Contrat {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message="Date Segne is empthy")
	@Column(name="dateSigne_contrat")
	@Temporal(TemporalType.DATE)
	private Date dateSigne;
	@NotNull(message="Date Debut is empthy")
	@Column(name="dateDebut_contrat")
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@NotNull(message="Date Fin is empthy")
	@Column(name="dateFin_contrat")
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	@OneToOne(fetch = FetchType.EAGER)
	private Entreprise entreprise;
	@OneToOne(fetch = FetchType.EAGER)
	private User user;
	
}
