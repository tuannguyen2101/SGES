package com.sges.service.impl;

import com.sges.entity.Gender;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.GenderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GenderServiceImpl extends GenericServiceImpl<Gender, Integer> implements GenderService {

    public GenderServiceImpl(JpaRepository<Gender, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
