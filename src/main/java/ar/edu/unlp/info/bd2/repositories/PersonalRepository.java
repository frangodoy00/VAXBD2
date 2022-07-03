package ar.edu.unlp.info.bd2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ar.edu.unlp.info.bd2.model.Personal;


public interface PersonalRepository extends CrudRepository <Personal, Integer>{
	
	@Query("from Personal p where p.fullName like %:name")
	public List<Personal> getStaffWithName(@Param("name") String name);

}
