package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.VaccinationSchedule;
import ar.edu.unlp.info.bd2.model.Vaccine;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VaccionationScheduleRepository
        extends CrudRepository<VaccinationSchedule, Integer> {
    public VaccinationSchedule createVaccinationSchedule() throws VaxException;
    public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule schedule);
    public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException;
    public VaccinationSchedule getVaccinationScheduleById(int id);
}
