package com.sges.generic.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sges.dto.OrderBy;
import com.sges.dto.Paging;
import com.sges.generic.GenericService;
import com.sges.utils.SortUtil;

@Transactional
public class GenericServiceImpl<T, ID> implements GenericService<T, ID>{

	@Autowired
    JpaRepository<T, ID> genericRepo;

    public JpaRepository<T, ID> getRepository() {
        return genericRepo;
    }

    public T findById(ID id) {
        return genericRepo.findById(id).orElse(null);
    }

    public List<T> findAll(List<ID> ids) {
        return genericRepo.findAllById(ids);
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

    @Override
    public List<T> findAll() {
        return genericRepo.findAll();
    }

    @Override
    public List<T> queryAllAndSort(List<OrderBy> orderBys) {
        if (orderBys == null || orderBys.isEmpty()) {
            return genericRepo.findAll();
        }
        return genericRepo.findAll(Sort.by(SortUtil.buildOrders(orderBys)));
    }

    @Override
    public List<T> findByExample(T e) {
        return genericRepo.findAll(Example.of(e));
    }

    @Override
    public List<T> findLimit(int numberSkip, int limit) {
        return genericRepo.findAll(PageRequest.of(numberSkip, limit)).getContent();
    }

    @Override
    public Page<T> findPage(int numberSkip, int limit, List<OrderBy> orderBys) {
        if (orderBys == null || orderBys.isEmpty()) {
            return genericRepo.findAll(PageRequest.of(numberSkip, limit));
        }
        return genericRepo.findAll(PageRequest.of(numberSkip, limit, SortUtil.buildSort(orderBys)));
    }

    public Object queryAllPageAndSort(List<OrderBy> orderBys, Paging pageInfo) {
        if (pageInfo == null) {
            return queryAllAndSort(orderBys);
        }
        return genericRepo.findAll(PageRequest.of(pageInfo.getIndex(), pageInfo.getSize(), SortUtil.buildSort(orderBys)));
    }

    @Override
    public Object queryByExamplePageAndSort(T e, Paging pageInfo, List<OrderBy> orderBys) {
        if (pageInfo == null) {
            return genericRepo.findAll(Example.of(e), SortUtil.buildSort(orderBys));
        }
        return genericRepo.findAll(Example.of(e),
                PageRequest.of(pageInfo.getIndex(), pageInfo.getSize(), SortUtil.buildSort(orderBys)));
    }
	
}
