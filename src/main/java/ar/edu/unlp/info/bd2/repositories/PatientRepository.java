package ar.edu.unlp.info.bd2.repositories;
import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PatientRepository extends CrudRepository <Patient, Integer>{

    public Optional<Patient> getPatientByEmail(String email);
}
