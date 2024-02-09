package com.bmh.beans;

public class PersonnelBean {
	private String matricule;
	private String nom;
	private String prenom;

	public PersonnelBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPersonnel() {
		return getMatricule() + " - " + getNom() + " " + getPrenom();
	}
}
