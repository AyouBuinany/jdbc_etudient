package com.model.app;

public class Etudient {
		private int id ;
		private String firstName;
		private String description;
		private String cni;
	public Etudient() {
		// TODO Auto-generated constructor stub
	}
	public Etudient(String firstName,String description ,String cni) {
		this.firstName=firstName;
		this.description=description;
		this.cni=cni;
	}
	public void setId(int id) {
		this.id= id;
	}
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCni() {
		return cni;
	}
	public void setCni(String cni) {
		this.cni = cni;
	}
	@Override
	public String toString() {
		return "Etudient [id=" + id + ", firstName=" + firstName + ", description=" + description + ", cni=" + cni+ "]";
	}

}
