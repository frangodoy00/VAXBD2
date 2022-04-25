package ar.edu.unlp.info.bd2.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "SupportStaff")
@Table(name = "supportStaff")
public class SupportStaff extends Personal{
	
	private Area area;

	public SupportStaff(String name, String dni, String area) {
		super(name,dni);
		this.area = new Area(area);
	}
	
	public SupportStaff(String name) {
		super(name);
	}
	
	
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
}
