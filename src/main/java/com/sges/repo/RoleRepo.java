package com.sges.repo;

import com.sges.entity.ERole;
import org.springframework.stereotype.Repository;
import com.sges.entity.Role;

import java.util.Optional;

@Repository
public interface RoleRepo extends BaseRepo<Role, Integer> {
    Optional<Role> findByRole(ERole roleName);
}
