package ar.edu.unlp.info.bd2.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Nurse")
@Table(name = "nurse")
public class Nurse extends Personal{

	private Integer yearsExperience;

	public Nurse(String name, String dni, int years) {
		super(name, dni);
		this.yearsExperience = years;
	}
	
	public Nurse(String name) {
		super(name);
	}
	
	public int getYearsExperience() {
		return yearsExperience;
	}

	public void setYearsExperience(int yearsExperience) {
		this.yearsExperience = yearsExperience;
	}
}
