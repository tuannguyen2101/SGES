package com.sges.service;

import com.sges.entity.User;
import com.sges.generic.BaseService;

public interface UserService extends BaseService<User, Integer> {
    User findUserByEmail(String email);
}
