package com.sges.service.impl;

import com.sges.entity.Reviews;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.ReviewsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewsServiceImpl extends GenericServiceImpl<Reviews, Integer> implements ReviewsService {

    public ReviewsServiceImpl(JpaRepository<Reviews, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
