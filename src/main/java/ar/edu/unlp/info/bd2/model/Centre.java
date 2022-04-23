package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Centre {

	private int id;
	private String name;
	private Collection<Personal> staffs;
	
	public Centre(String name){
		this.name = name;
		this.staffs = new ArrayList<Personal>();
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
	public Collection<Personal> getStaffs() {
		return staffs;
	}
	public void setStaffs(Collection<Personal> staff) {
		this.staffs = staff;
	}
	
	public void addStaff(Personal staff){
		this.staffs.add(staff);
	}
	
}
