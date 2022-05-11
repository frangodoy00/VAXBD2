package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity(name = "personal")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "personal_type", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Personal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	@Column( name = "fullName")
	protected String fullName;
	@Column( name = "dni", unique=true)
	protected String dni;
	@ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "staffs")
	protected Collection<Centre> centres;
	
	public Personal(String name, String dni) {
		this.fullName = name;
		this.dni = dni;
		this.centres = new ArrayList<Centre>();
	}
	public Personal(String name){
		this.fullName = name;
	}

	public Personal() {

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
	
	public void addCentre(Centre centre){
		this.centres.add(centre);
	}
	
}
