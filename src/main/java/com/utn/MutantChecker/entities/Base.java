package com.utn.MutantChecker.entities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Base implements Serializable {

}
