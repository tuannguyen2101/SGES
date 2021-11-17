package com.sges.repo;

import org.springframework.stereotype.Repository;
import com.sges.entity.User;

import java.util.Optional;

@Repository
public interface UserRepo extends BaseRepo<User, Integer> {

    User findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    User findByOtpCode(String code);

    User findByEmail(String email);
}
