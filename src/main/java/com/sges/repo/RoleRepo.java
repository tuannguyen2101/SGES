package com.sges.repo;

import org.springframework.stereotype.Repository;
import com.sges.entity.Role;

@Repository
public interface RoleRepo extends BaseRepo<Role, Integer> {
}
