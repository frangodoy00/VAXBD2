package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Vaccine;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VaccineRepository extends CrudRepository<Vaccine, Integer> {
    @Query("select v from Vaccine v where v.name = :name")
    public List<Optional<Vaccine>> getVaccineByName(@Param("name") String name, Pageable pageable);

    @Query("select v from Vaccine v where v.id not in (select distinct v.id from Vaccine v INNER JOIN Shot s ON(v.id=s.vaccine))")
    public List<Vaccine> getUnappliedVaccines();
}
