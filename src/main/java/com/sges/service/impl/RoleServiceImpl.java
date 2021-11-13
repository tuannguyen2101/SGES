package com.sges.service.impl;

import com.sges.entity.ERole;
import com.sges.entity.Role;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.repo.RoleRepo;
import com.sges.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, Integer> implements RoleService {
    @Autowired
    RoleRepo roleRepo;

    public RoleServiceImpl(JpaRepository<Role, Integer> jpaRepository) {
        super(jpaRepository);
    }

    @Override
    public Optional<Role> findByRole(ERole roleName) {
        return roleRepo.findByRole(roleName);
    }
}
