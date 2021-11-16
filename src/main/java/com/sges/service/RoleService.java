package com.sges.service;

import com.sges.entity.ERole;
import com.sges.entity.Role;
import com.sges.generic.BaseService;

import java.util.Optional;

public interface RoleService extends BaseService<Role, Integer> {
	Optional<Role> findByRole(ERole roleName);
}
