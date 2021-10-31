package com.sges.service.impl;

import com.sges.entity.Role;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.RoleService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, Integer> implements RoleService {

    public RoleServiceImpl(JpaRepository<Role, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
