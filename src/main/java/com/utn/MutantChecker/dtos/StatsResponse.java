package com.utn.MutantChecker.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StatsResponse {
    @JsonProperty("mutants")
    private long cantMutantsDna;
    @JsonProperty("humans")
    private long cantHumansDna;
    private double ratio;

}
