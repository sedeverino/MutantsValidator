package com.utn.MutantChecker.services;

import com.utn.MutantChecker.dtos.StatsResponse;
import com.utn.MutantChecker.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {
    @Autowired
    private final DnaRepository dnaRepo;

    public StatsService(DnaRepository dnaRepository) {
        this.dnaRepo = dnaRepository;
    }

    public StatsResponse getStats(){
        long countMutants = dnaRepo.countMutants(true);
        long countHumans = dnaRepo.countMutants(false);
        double ratio = countHumans == 0 ? 0 : (double)  countMutants / countHumans;
        return StatsResponse.builder().cantHumansDna(countHumans).cantMutantsDna(countMutants).build();

    }
}
