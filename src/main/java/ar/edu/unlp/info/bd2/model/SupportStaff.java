package ar.edu.unlp.info.bd2.model;

public class SupportStaff extends Personal{
	
	private Area area;

	public SupportStaff(String name, int dni, Area area) {
		super(name,dni);
		this.area = area;
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
