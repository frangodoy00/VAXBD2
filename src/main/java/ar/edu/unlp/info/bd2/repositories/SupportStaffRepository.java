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

	List<SupportStaff> findByDni(String dni);
	
	@Query("select s.area from SupportStaff s where s.area is not null group by s.area order by count(*) asc")
	public List<String> getLessEmployeesSupportStaffArea(Pageable pageable);
}
