package com.sges.service.impl;

import com.sges.generic.BaseService;
import com.sges.generic.impl.GenericServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TransportServiceImpl extends GenericServiceImpl<Transport, Integer> implements BaseService<Transport, Integer> {

    public TransportServiceImpl(JpaRepository<Transport, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
