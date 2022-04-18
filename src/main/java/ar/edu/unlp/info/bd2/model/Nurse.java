package ar.edu.unlp.info.bd2.model;

public class Nurse extends Personal{

	private int yearsExperience;

	public Nurse(String name, int dni, int years) {
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
