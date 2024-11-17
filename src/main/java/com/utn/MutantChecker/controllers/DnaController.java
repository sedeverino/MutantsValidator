package com.utn.MutantChecker.controllers;

import com.utn.MutantChecker.dtos.DnaRequest;
import com.utn.MutantChecker.dtos.DnaResponse;
import com.utn.MutantChecker.services.MutantServices;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mutant")
public class DnaController {

    @Autowired
    private static MutantServices mutantServices;

    @PostMapping
    public ResponseEntity<DnaResponse> checkMutant(@Valid @RequestBody DnaRequest dnaRequest){
        boolean isMutantController = mutantServices.analyzeData(dnaRequest.getDna());
        DnaResponse dna = DnaResponse.builder().ismutant(isMutantController).build();
        return isMutantController ? ResponseEntity.ok(dna) : ResponseEntity.status(HttpStatus.FORBIDDEN).body(dna);
    }


}
