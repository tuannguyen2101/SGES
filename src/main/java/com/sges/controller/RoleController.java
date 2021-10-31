package com.sges.controller;

import com.sges.entity.Role;
import com.sges.generic.BaseService;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController extends GenericController<Role, Integer>{

    public RoleController(BaseService<Role, Integer> baseService) {
        super(baseService);
    }
}
