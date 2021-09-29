package com.sges.generic;

import java.util.List;

import org.springframework.data.domain.Page;

import com.sges.dto.OrderBy;
import com.sges.dto.Paging;

public interface GenericService <T, ID>{
	
	T findById(ID id);

    List<T> findAll(List<ID> ids);

    T save(T obj);

    List<T> save(List<T> lst) throws Exception;

    void delete(ID key);

    void delete(List<T> lst);

    void deleteAll();

    boolean existsById(ID key);

    List<T> queryAllAndSort(List<OrderBy> orderBys);

    List<T> findByExample(T e);

    List<T> findLimit(int numberSkip, int limit);

    Page<T> findPage(int numberSkip, int limit, List<OrderBy> orderBys);

    Object queryByExamplePageAndSort(T e, Paging pageInfo, List<OrderBy> orderBys);

    List<T> findAll();
	
}
