package com.sges.service.impl;

import com.sges.entity.Color;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.ColorService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ColorServiceImpl extends GenericServiceImpl<Color, Integer> implements ColorService {

    public ColorServiceImpl(JpaRepository<Color, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
