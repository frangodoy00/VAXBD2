package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Patient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends CrudRepository <Patient, Integer>{

    @Query("select p from Patient p where p.email = :email")
    public List<Optional<Patient>> getPatientByEmail(@Param("email") String email, Pageable pageable);

    @Query("select p from Patient p")
    public List<Patient> getAllPatients();
}
