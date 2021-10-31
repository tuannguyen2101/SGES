package com.sges.service.impl;

import com.sges.entity.Size;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.SizeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SizeServiceImpl extends GenericServiceImpl<Size, Integer> implements SizeService {

    public SizeServiceImpl(JpaRepository<Size, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
