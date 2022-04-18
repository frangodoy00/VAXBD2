package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;
import java.util.List;

public class Centre {

	private int id;
	private String name;
	private List<Personal> staff;
	
	public Centre(String name){
		this.name = name;
		this.staff = new ArrayList<Personal>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Personal> getStaff() {
		return staff;
	}
	public void setStaff(List<Personal> staff) {
		this.staff = staff;
	}
	
	
}
