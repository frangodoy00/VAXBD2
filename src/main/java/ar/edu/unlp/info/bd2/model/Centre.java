package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table ( name  = "Centre")
public class Centre {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name = "Id", unique = true, nullable = false)
	private int id;

	@Column( name = "Name")
	private String name;

	@ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn( name = "Staffs")
	private Collection<Personal> staffs;

	public Centre(){

	}
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
