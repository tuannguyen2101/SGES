package com.sges.service.impl;

import com.sges.entity.User;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.repo.UserRepo;
import com.sges.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService {

    public UserServiceImpl(JpaRepository<User, Integer> jpaRepository) {
        super(jpaRepository);
    }
    @Autowired
    UserRepo userRepo;

    @Override
    public User findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }
}
