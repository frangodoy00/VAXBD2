package ar.edu.unlp.info.bd2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unlp.info.bd2.model.Personal;


public interface PersonalRepository extends CrudRepository <Personal, Integer>{
	
	public List<Personal> getStaffWithName(String name);

}
