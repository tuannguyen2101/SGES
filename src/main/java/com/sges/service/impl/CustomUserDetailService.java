package com.sges.service.impl;

import com.sges.dto.CustomUserDetail;
import com.sges.entity.User;
import com.sges.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User account = this.userRepo.findByUsername(username);
        if(account == null) {
            throw new UsernameNotFoundException(username);
        }
        else return new CustomUserDetail(account);
    }

}
