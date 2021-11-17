package com.sges.service;

import com.sges.entity.User;
import com.sges.generic.BaseService;

import java.util.Optional;

public interface UserService extends BaseService<User, Integer> {
    User findUserByEmail(String email);
    User findByName(String name);
    User save(User user);
    boolean existByUserName(String username);
    boolean existByEmail(String email);
}
