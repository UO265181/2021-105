package com.uniovi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String DNI;
	private String name;
	private String lastName;
	private String category;
	
	
	public Teacher(Long id,String DNI, String name, String lastName, String category) {
		super();
		this.setId(id);
		this.DNI = DNI;
		this.name = name;
		this.lastName = lastName;
		this.category = category;
	}
	
	public Teacher() {}
	
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Teacher [DNI=" + DNI + ", name=" + name + ", lastName=" + lastName + ", category=" + category + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	

}
