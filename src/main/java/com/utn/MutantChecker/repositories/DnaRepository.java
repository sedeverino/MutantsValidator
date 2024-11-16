package com.utn.MutantChecker.repositories;

import com.utn.MutantChecker.entities.Dna;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DnaRepository extends IBaseRepository<Dna,Long>{
    @Query("SELECT d FROM Dna d WHERE d.sequence = :dnaSequence")
    Optional<Dna> findBySequence(String dnaSecuence);

    @Query("SELECT COUNT(d) FROM Dna d WHERE d.isMutant = :isMutant")
    Long countMutants(boolean isMutant);
}
