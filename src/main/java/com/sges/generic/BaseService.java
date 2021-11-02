package com.sges.generic;

import org.springframework.data.domain.Page;

import java.util.List;

public interface BaseService<T, ID>{

    List<T> findAll();

    Page<T> findPage(int page, int size);

    T findById(ID id);

    T create(T obj);

    T update(T obj);

    void delete(ID key);

    boolean existsById(ID key);

    Long count();
	
}
