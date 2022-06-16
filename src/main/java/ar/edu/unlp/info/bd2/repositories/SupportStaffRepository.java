package ar.edu.unlp.info.bd2.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unlp.info.bd2.model.SupportStaff;

public interface SupportStaffRepository extends CrudRepository <SupportStaff, Integer>{
		
	public SupportStaff getSupportStaffById(int id);
	public Optional<SupportStaff> getSupportStaffByDni(String dni);
	public String getLessEmployeesSupportStaffArea();
}
