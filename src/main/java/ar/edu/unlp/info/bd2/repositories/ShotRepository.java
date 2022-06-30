package ar.edu.unlp.info.bd2.repositories;


import ar.edu.unlp.info.bd2.model.Shot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Date;

public interface ShotRepository extends CrudRepository <Shot, Integer> {

    @Query("select s from Shot p where s.id = :id")
    public Optional<Shot> getShotById(@Param("id") int id, Pageable pageable);




}
