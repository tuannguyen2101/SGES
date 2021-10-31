package com.sges.service.impl;

import com.sges.entity.Authority;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.repo.AuthorityRepo;
import com.sges.service.AuthorityService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl extends GenericServiceImpl<Authority, Integer> implements AuthorityService {

    public AuthorityServiceImpl(JpaRepository<Authority, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
