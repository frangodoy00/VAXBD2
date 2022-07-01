package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.VaccinationSchedule;
import ar.edu.unlp.info.bd2.model.Vaccine;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VaccionationScheduleRepository
        extends CrudRepository<VaccinationSchedule, Integer> {
    @Query("from VaccinationSchedule v where v.id = :id")
    public List<VaccinationSchedule> getVaccinationScheduleById(@Param("id") Long id, Pageable pageable) throws VaxException;
    
    @Query("from VaccinationSchedule v where v.id = :id")
    public List<VaccinationSchedule> getVaccinationScheduleById(@Param("id") int id, Pageable pageable);
}
