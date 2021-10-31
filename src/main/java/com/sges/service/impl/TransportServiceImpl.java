package com.sges.service.impl;

import com.sges.entity.Transport;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.TransportService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TransportServiceImpl extends GenericServiceImpl<Transport, Integer> implements TransportService {

    public TransportServiceImpl(JpaRepository<Transport, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
