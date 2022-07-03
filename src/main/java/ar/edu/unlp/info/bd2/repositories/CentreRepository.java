package ar.edu.unlp.info.bd2.repositories;
import java.util.List;
import java.util.Optional;

import ar.edu.unlp.info.bd2.model.Centre;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CentreRepository extends CrudRepository <Centre, Integer> {

	@Query("select c from Centre c where c.id = :id")
	public List<Centre> getCentreById(@Param("id") int id, Pageable pageable);

	List<Centre> findByName(String name);
	/// @Query("select c from Centre c where c.name = :name")
	/// public List<Optional<Centre>> getCentreByName(@Param("name") String name, Pageable pageable);

	// public Centre updateCentre(Centre centre);


	@Query("select c from Centre c join c.staffs as st group by c.id order by count(st) desc")
	public List<Centre> getCentresTopNStaff();

	@Query("select s.centre from Shot s group by s.centre order by count(s.centre) desc")
	public List<Centre> getTopShotCentre();



}
