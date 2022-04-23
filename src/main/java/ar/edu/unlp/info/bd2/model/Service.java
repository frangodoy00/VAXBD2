package ar.edu.unlp.info.bd2.model;

import java.util.Collection;
import java.util.List;

public class Service {

	private Collection<Nurse> nurses;
	private Collection<Centre> centres;
	
	public void addCentre(Centre centro){
		this.centres.add(centro);
	}
	
}
