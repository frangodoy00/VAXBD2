package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.ShotCertificate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ShotCertificateRepository extends CrudRepository<ShotCertificate, Integer> {

    @Query("select s from ShotCertificate s where s.date BETWEEN :startDate AND :endDate")
    public List<ShotCertificate> getShotCertificatesBetweenDates(@Param("startDate, endDate") Date startDate, Date endDate);

}
