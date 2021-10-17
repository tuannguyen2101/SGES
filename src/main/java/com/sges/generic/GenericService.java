package com.sges.generic;

import java.util.List;

import org.springframework.data.domain.Page;
import com.sges.dto.OrderBy;

public interface GenericService <T, ID>{
	
    Page<T> findPage(int page, int size, OrderBy orderBy);
	
    List<T> findAll();
    
	T findById(ID id);

    T save(T obj);

    List<T> save(List<T> lst) throws Exception;

    void delete(ID key);

    void delete(List<T> lst);

    void deleteAll();

    boolean existsById(ID key);
	
}
