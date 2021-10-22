package com.sges.generic.impl;

import com.sges.dto.OrderBy;
import com.sges.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class GenericServiceImpl<T, ID> implements GenericService<T, ID>{

	final
    JpaRepository<T, ID> genericRepo;

    public GenericServiceImpl(JpaRepository<T, ID> genericRepo) {
        this.genericRepo = genericRepo;
    }

    public JpaRepository<T, ID> getRepository() {
        return genericRepo;
    }

    @Override
    public Page<T> findPage(int page, int size, OrderBy orderBy) {
        return genericRepo.findAll(PageRequest.of(page, size, Sort.by(orderBy.getProperty(), orderBy.getDirection())));
    }
    
    @Override
    public List<T> findAll() {
        return genericRepo.findAll();
    }
    
    public T findById(ID id) {
        return genericRepo.findById(id).orElse(null);
    }

    public T save(T obj) {
        return genericRepo.save(obj);
    }

    public List<T> save(List<T> lst) throws Exception {
        return genericRepo.saveAll(lst);
    }

    public void delete(ID key) {
        genericRepo.deleteById(key);
    }

    public void delete(List<T> lst) {
        genericRepo.deleteAll(lst);
    }

    public void deleteAll() {
        genericRepo.deleteAll();
    }

    public boolean existsById(ID key) {
        return genericRepo.existsById(key);
    }
	
}
