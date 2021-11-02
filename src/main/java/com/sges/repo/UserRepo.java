package com.sges.repo;

import org.springframework.stereotype.Repository;
import com.sges.entity.User;

@Repository
public interface UserRepo extends BaseRepo<User, Integer> {

    User findByUsername(String username);

}
