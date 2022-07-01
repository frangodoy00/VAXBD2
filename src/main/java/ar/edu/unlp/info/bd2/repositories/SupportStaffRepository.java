package ar.edu.unlp.info.bd2.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Nurse;
import ar.edu.unlp.info.bd2.model.SupportStaff;

public interface SupportStaffRepository extends CrudRepository <SupportStaff, Integer>{

	@Query("select s from SupportStaff s where s.id = :id")
	public List<SupportStaff> getSupportStaffById(@Param("id") int id, Pageable pageable);
	
	@Query("select s from SupportStaff s where s.dni = :dni")
	public List<Optional<SupportStaff>> getSupportStaffByDni(@Param("dni") String dni, Pageable pageable);
	
	@Query("select s.area from SupportStaff s where s.area is not null group by s.area order by count(*) asc")
	public List<String> getLessEmployeesSupportStaffArea(Pageable pageable);
}
