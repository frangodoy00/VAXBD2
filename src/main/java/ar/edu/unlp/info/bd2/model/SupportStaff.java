package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("2")
public class SupportStaff extends Personal{


	@Column(name = "area")
	private String area;

	public SupportStaff(String name, String dni, String area) {
		super(name,dni);
		this.area = area;
	}
	
	public SupportStaff(String name) {
		super(name);
	}

	public SupportStaff() {

	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}
