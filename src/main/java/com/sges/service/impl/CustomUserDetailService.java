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
        User user = userRepo.findByUsername(username);
        if (user==null){
          return (UserDetails) new UsernameNotFoundException("User Not Found with username: " + username);
        }
//        User user = userRepo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User Not Found with username: " + username));
        return CustomUserDetail.build(user);
    }

//    public User save(SignupRequest user){
//        User newUser = new User();
//        newUser.setUsername(user.getUsername());
//        newUser.setPassword(user.getPassword());
//        newUser.setAvatar(user.getAvatar());
//        newUser.setFullname(user.getFullname());
//        newUser.setEmail(user.getPhone());
//        newUser.setGender(user.getGender());
//        newUser.setStatus(user.getStatus());
//        return userRepo.save(newUser);
//    }
}
