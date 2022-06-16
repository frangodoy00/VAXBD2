package ar.edu.unlp.info.bd2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unlp.info.bd2.model.Nurse;

public interface NurseRepository extends CrudRepository <Nurse, Integer> {

	public Nurse getNurseById(int id);
	public List<Nurse> getNurseWithMoreThanNYearsExperience(int years);
	public List<Nurse> getNurseNotShot();
}
