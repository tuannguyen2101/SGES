package com.sges.service.impl;

import com.sges.entity.User;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, String> implements UserService {

}
