package com.utn.MutantChecker.entities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import com.utn.MutantChecker.entities.Base;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Dna extends Base implements Serializable {
    private boolean ismutant;
    private String dna;
}
