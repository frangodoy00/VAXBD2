package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Personal {
	
	protected int id;
	protected String fullName;
	protected int dni;
	protected Collection<Centre> centres;
	
	public Personal(String name, int dni) {
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
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public Collection<Centre> getCentres(){
		return this.centres;
	}
	
}
