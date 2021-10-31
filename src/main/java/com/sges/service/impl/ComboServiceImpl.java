package com.sges.service.impl;

import com.sges.entity.Combo;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.ComboService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ComboServiceImpl extends GenericServiceImpl<Combo, Integer> implements ComboService {

    public ComboServiceImpl(JpaRepository<Combo, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
