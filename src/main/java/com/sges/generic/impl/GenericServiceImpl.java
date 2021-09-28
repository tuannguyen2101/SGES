package com.sges.generic.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sges.generic.GenericService;
import com.sges.request.entity.OrderBy;
import com.sges.utils.SortUtils;

@Transactional
public class GenericServiceImpl<T, ID> implements GenericService<T, ID>{

	@Autowired
	JpaRepository<T, ID> jpaRepository;
	
	@Override
	public T findById(ID id) {
		return jpaRepository.findById(id).orElse(null);
	}

	@Override
	public List<T> findAll(List<ID> ids) {
		return jpaRepository.findAllById(ids);
	}

	@Override
	public T save(T obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public List<T> save(List<T> lst) throws Exception {
		return jpaRepository.saveAll(lst);
	}

	@Override
	public void delete(ID key) {
		jpaRepository.deleteById(key);
	}

	@Override
	public void delete(List<T> lst) {
		jpaRepository.deleteAll(lst);
		
	}

	@Override
	public void deleteAll() {
		jpaRepository.deleteAll();
	}

	@Override
	public boolean existsById(ID key) {
		return jpaRepository.existsById(key);
	}

	@Override
	public List<T> findByExample(T e) {
		return jpaRepository.findAll(Example.of(e));
	}

	@Override
	public List<T> findLimit(int numberSkip, int limit) {
		return jpaRepository.findAll(PageRequest.of(numberSkip, limit)).getContent();
	}

	@Override
	public Page<T> findPage(int numberSkip, int limit, List<OrderBy> orderBys) {
		if (orderBys == null || orderBys.isEmpty()) {
            return jpaRepository.findAll(PageRequest.of(numberSkip, limit));
        }
        return jpaRepository.findAll(PageRequest.of(numberSkip, limit, SortUtils.buildSort(orderBys)));
	}

	@Override
	public List<T> findAll() {
		return this.findAll();
	}
	
}
