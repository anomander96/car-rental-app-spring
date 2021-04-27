package com.lab.app.repository;

import com.lab.app.model.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccidentRepository extends JpaRepository<Accident, Long> {

    Optional<Accident> findByAccidentId(Long accidentId);
}
