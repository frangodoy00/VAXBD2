package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("2")
public class SupportStaff extends Personal{


	@OneToOne
	//Alternativa, consultar:
	//	@ManyToOne(fetch = FetchType.EAGER)
	//	@JoinColumn(name = "area_id")
	private Area area;

	public SupportStaff(String name, String dni, String area) {
		super(name,dni);
		this.area = new Area(area);
	}
	
	public SupportStaff(String name) {
		super(name);
	}

	public SupportStaff() {

	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
}
