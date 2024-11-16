package com.utn.MutantChecker.repositories;

import com.utn.MutantChecker.entities.Dna;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDnaRepository extends IBaseRepository<Dna,Long>{
    Optional<Dna> findBySequence(String dnaSecuence);
    Long countMutants(boolean isMutant);
}
