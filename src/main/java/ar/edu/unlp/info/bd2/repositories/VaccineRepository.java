package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Vaccine;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VaccineRepository extends CrudRepository<Vaccine, Integer> {
    public Optional<Vaccine> getVaccineByName(String name);
}
