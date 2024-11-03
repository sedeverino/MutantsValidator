package com.utn.MutantChecker.services;

import java.io.Serializable;
import java.util.List;

public interface IBaseServices<E, ID extends Serializable>{
    List<E> findAll() throws Exception;
    E findByID(ID id) throws Exception;
    E save(E entity) throws Exception;
    E update(ID id, E entity) throws Exception;
    boolean delete(ID id) throws Exception;
}
