package com.utn.MutantChecker.services;

import com.utn.MutantChecker.repositories.IBaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServicesImpl<E, ID extends Serializable> implements IBaseServices<E, ID> {
    @Autowired
    protected IBaseRepository<E,ID> baseRepository;

    @Override
    @Transactional
    public List<E> findAll() throws Exception {
        try{
            return baseRepository.findAll();
        }catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E findByID(ID id) throws Exception {
        try{
            Optional<E> entityOptional = baseRepository.findById(id);
            return entityOptional.orElse(null);
        }catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try{
            return baseRepository.save(entity);
        }catch (DataAccessException e){
            throw new Exception("An error has ocurred during saving process");
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try{
            Optional<E> entityOptional = baseRepository.findById(id);
            if (entityOptional.isPresent()) {
                E entityUpdated = entityOptional.get();
                // Copia solo las propiedades no nulas de "entity" a "entityUpdated"
                BeanUtils.copyProperties(entity, entityUpdated);
                baseRepository.save(entityUpdated);
                return entityUpdated;
            } else {
                throw new Exception("Entity with ID " + id + " not found");
            }
        }catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(ID id) throws Exception {
        try{
            if(baseRepository.existsById(id)){
                baseRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }
    }

}
