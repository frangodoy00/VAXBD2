package ar.edu.unlp.info.bd2.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Nurse extends Personal{

	@Column( name = "yearsExperience")
	private Integer yearsExperience;

	public Nurse(String name, String dni, int years) {
		super(name, dni);
		this.yearsExperience = years;
	}
	
	public Nurse(String name) {
		super(name);
	}

	public Nurse() {
		super();
	}

	public int getYearsExperience() {
		return yearsExperience;
	}

	public Integer getExperience() {
		return yearsExperience;
	}

	public void setYearsExperience(int yearsExperience) {
		this.yearsExperience = yearsExperience;
	}
}
