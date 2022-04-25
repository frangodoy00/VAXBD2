package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "Personal")
public abstract class Personal {
	
	@Id
	@GeneratedValue
	protected int id;
	protected String fullName;
	@Column(unique=true)
	protected String dni;
	@ManyToMany(mappedBy = "staffs")
	protected Collection<Centre> centres;
	
	public Personal(String name, String dni) {
		this.fullName = name;
		this.dni = dni;
		this.centres = new ArrayList<Centre>();
	}
	public Personal(String name){
		this.fullName = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String name) {
		this.fullName = name;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public Collection<Centre> getCentres(){
		return this.centres;
	}
	
}
