package com.sges.generic.impl;

import com.sges.generic.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class GenericServiceImpl<T, ID> implements BaseService<T, ID> {

    private final JpaRepository<T, ID> jpaRepository;

    public GenericServiceImpl(JpaRepository<T, ID> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<T> findAll() {
        return this.jpaRepository.findAll();
    }

    @Override
    public Page<T> findPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.jpaRepository.findAll(pageable);
    }

    @Override
    public T findById(ID id) {
        return this.jpaRepository.findById(id).get();
    }

    @Override
    public T create(T obj) {
        return this.jpaRepository.save(obj);
    }

    @Override
    public T update(T obj) {
        return this.jpaRepository.save(obj);
    }

    @Override
    public void delete(ID key) {
        if (this.jpaRepository.existsById(key)) {
            this.jpaRepository.deleteById(key);
        }
    }

    @Override
    public Long count() {
        return jpaRepository.count();
    }

    @Override
    public boolean existsById(ID key) {
        return jpaRepository.existsById(key);
    }


}
