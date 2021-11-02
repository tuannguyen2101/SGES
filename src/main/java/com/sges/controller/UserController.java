package com.sges.controller;

import com.sges.entity.User;
import com.sges.generic.BaseService;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends GenericController<User, Integer>{

    public UserController(BaseService<User, Integer> baseService) {
        super(baseService);
    }
}
