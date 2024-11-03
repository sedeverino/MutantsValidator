package com.utn.MutantChecker.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface IBaseRepository<E, ID extends Serializable> extends JpaRepository<E, ID> {
}
