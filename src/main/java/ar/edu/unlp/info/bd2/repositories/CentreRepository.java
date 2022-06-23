package ar.edu.unlp.info.bd2.repositories;
import java.util.Optional;

import ar.edu.unlp.info.bd2.model.Centre;
import org.springframework.data.repository.CrudRepository;


public interface CentreRepository extends CrudRepository <Centre, Integer> {

	public Centre getCentreById(int id);
	public Optional<Centre>getCentreByName(String name);

}
