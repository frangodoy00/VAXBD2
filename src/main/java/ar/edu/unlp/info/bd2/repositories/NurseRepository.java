package ar.edu.unlp.info.bd2.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Nurse;

public interface NurseRepository extends CrudRepository <Nurse, Integer> {
	
	List<Nurse> findByDni(String dni);
	
	@Query("select n from Nurse n where n.yearsExperience > :years")
	public List<Nurse> getNurseWithMoreThanNYearsExperience(@Param("years") int years);
	
	@Query("select n from Nurse n where n.id not in (select distinct n.id from Nurse n INNER JOIN Shot s ON(n.id = s.nurse))")
	public List<Nurse> getNurseNotShot();
}
