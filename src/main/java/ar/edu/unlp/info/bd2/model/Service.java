package ar.edu.unlp.info.bd2.model;

import java.util.List;

public class Service {

	private List<Nurse> nurses;
	private List<Centre> centres;
	
	public void addCentre(Centre centro){
		this.centres.add(centro);
	}
	
}
