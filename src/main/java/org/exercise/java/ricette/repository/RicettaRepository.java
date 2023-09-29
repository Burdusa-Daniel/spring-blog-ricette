package org.exercise.java.ricette.repository;

import org.exercise.java.ricette.model.Ricetta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RicettaRepository extends JpaRepository<Ricetta,Integer> {
}
