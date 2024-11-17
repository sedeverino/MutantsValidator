package com.utn.MutantChecker.dtos;

import com.utn.MutantChecker.validators.ValidDna;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DnaRequest {

    @ValidDna
    private String[] dna;
}
